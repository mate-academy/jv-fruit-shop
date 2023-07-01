package core.basesyntax.model;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReadDataFromFile;
import core.basesyntax.service.impl.ReadDataFromFileImpl;
import core.basesyntax.service.strategy.OperationStrategy;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private Map<String, OperationStrategy> operationStrategies;

    public FruitServiceImpl(Map<String, OperationStrategy> operationStrategies) {
        this.operationStrategies = operationStrategies;
    }

    @Override
    public Map<String, Integer> processFruitTransactions(String inputFileName) throws IOException {
        Storage storage = new Storage();
        ReadDataFromFile readDataFromFile = new ReadDataFromFileImpl();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line = reader.readLine(); //Skip header
            while ((line = reader.readLine()) != null) {
                FruitTransaction transaction = readDataFromFile.readDataFromfile(line);
                OperationStrategy strategy = operationStrategies
                        .get(transaction.getOperation().getCode());
                if (strategy != null) {
                    strategy.process(transaction, storage);
                }
            }
        }
        return storage.getInventory();
    }
}
