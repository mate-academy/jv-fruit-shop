package service.impl;

import java.util.List;
import model.FruitTransaction;
import service.OperationStrategy;
import service.ProcessingDataService;
import service.strategy.OperationHandler;

public class ProcessingDataServiceImpl implements ProcessingDataService {
    private static final String DELIMITER = ",";
    private OperationStrategy operationStrategy;

    public ProcessingDataServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void updateDataInStorage(List<String> readData) {
        for (String line : readData) {
            FruitTransaction transaction = new FruitTransaction();
            String[] separatedData = line.split(DELIMITER);
            transaction.setFruit(separatedData[1]);
            transaction.setQuantity(Integer.parseInt(separatedData[2]));
            updateNumberOfFruitInOneTransactionAccordingToHandler(separatedData[0], transaction);
        }
    }

    private void updateNumberOfFruitInOneTransactionAccordingToHandler(
            String code, FruitTransaction transaction) {
        OperationHandler handlerForTransaction = operationStrategy
                .getOperationHandler(FruitTransaction.Operation.getOperation(code));
        handlerForTransaction.updateNumberOfFruit(transaction);
    }
}
