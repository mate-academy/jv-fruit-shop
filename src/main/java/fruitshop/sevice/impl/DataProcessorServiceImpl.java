package fruitshop.sevice.impl;

import fruitshop.model.FruitTransaction;
import fruitshop.sevice.DataProcessorService;
import java.util.ArrayList;
import java.util.List;

public class DataProcessorServiceImpl implements DataProcessorService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> processInputData(List<String> dataFromFile) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String line : dataFromFile) {
            String[] processedData = line.split(SEPARATOR);
            FruitTransaction.Operation operationByCode = FruitTransaction
                    .Operation.getOperationByCode(
                            processedData[OPERATION_INDEX]);
            String fruitType = processedData[FRUIT_INDEX];
            int quantity = Integer.parseInt(processedData[AMOUNT_INDEX]);
            fruitTransactions.add(
                    new FruitTransaction(operationByCode, fruitType, quantity));
        }
        return fruitTransactions;
    }
}
