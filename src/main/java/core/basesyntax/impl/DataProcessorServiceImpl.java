package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.DataProcessorService;
import java.util.ArrayList;
import java.util.List;

public class DataProcessorServiceImpl implements DataProcessorService {
    private static final String SPLIT_DELIMITER = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> processInputData(List<String> dataFromFile) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String line : dataFromFile) {
            String[] processedData = line.split(SPLIT_DELIMITER);
            FruitTransaction.Operation operation = FruitTransaction.Operation
                            .getOperationByCode(processedData[OPERATION_TYPE_INDEX]);
            String fruitType = processedData[FRUIT_TYPE_INDEX];
            int fruitQuantity = Integer.parseInt(processedData[FRUIT_QUANTITY_INDEX]);
            fruitTransactions.add(new FruitTransaction(operation, fruitType, fruitQuantity));
        }
        return fruitTransactions;
    }
}
