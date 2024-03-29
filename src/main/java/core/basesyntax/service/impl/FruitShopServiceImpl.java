package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.operation.Operation;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.OperationService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private FileReaderServiceImpl fileReader = new FileReaderServiceImpl();

    @Override
    public Map<String, Integer> fruitTransaction(String path) {
        List<String> lines = fileReader.readData(path);
        for (String line : lines) {
            String[] meaning = line.split(",");
            OperationService operationService = OperationStrategy
                    .getOperation(Operation.getOperationFromCode(meaning[0]));
            operationService.operation(line);
        }
        return Storage.storage;
    }
}
