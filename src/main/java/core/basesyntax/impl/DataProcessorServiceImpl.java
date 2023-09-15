package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.DataProcessorService;
import core.basesyntax.services.OperationProcessor;

import java.util.ArrayList;
import java.util.List;

public class DataProcessorServiceImpl implements DataProcessorService {

    @Override
    public List<FruitTransaction> processInputData(List<String> dataFromFile) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String line : dataFromFile) {
            String[] processedData = line.split(",");
            FruitTransaction.Operation operation = FruitTransaction.Operation.getOperationByCode(processedData[0]);
            String fruitType = processedData[1];
            int fruitQuantity = Integer.parseInt(processedData[2]);
            fruitTransactions.add(new FruitTransaction(operation , fruitType , fruitQuantity));
        }
        return fruitTransactions;
    }

}
