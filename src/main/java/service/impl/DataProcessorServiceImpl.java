package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.DataProcessorService;
import service.OperationStrategy;
import service.strategy.OperationHandler;

public class DataProcessorServiceImpl implements DataProcessorService {
    private static final String DELIMITER = ",";
    private static final int HEADER_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private OperationStrategy operationStrategy;

    public DataProcessorServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processData(List<String> readData) {
        readData.remove(HEADER_INDEX);
        for (String line : readData) {
            FruitTransaction transaction = new FruitTransaction();
            String[] separatedData = line.split(DELIMITER);
            transaction.setFruit(separatedData[FRUIT_INDEX]);
            transaction.setQuantity(Integer.parseInt(separatedData[QUANTITY_INDEX]));
            updateFruitTransaction(separatedData[OPERATION_INDEX], transaction);
        }
    }

    private void updateFruitTransaction(String code, FruitTransaction transaction) {
        OperationHandler handlerForTransaction = operationStrategy
                .getOperationHandler(FruitTransaction.Operation.getOperation(code));
        handlerForTransaction.handleOperation(transaction);
    }
}
