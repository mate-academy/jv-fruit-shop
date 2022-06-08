package core.service;

import core.service.handlers.OperationHandler;

import java.util.List;

public class FruitTransactionProcessorServiceImpl implements FruitTransactionProcessorService {
    private final OperationHandlerStrategy operationHandlerStrategy;
    private final int OPERATION_POS = 0;
    private final int FRUIT_NAME_POS = 1;
    private final int FRUITS_QUANTITY_POS = 2;
    private final String DELIMITER = ",";

    public FruitTransactionProcessorServiceImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    public void fillStorage(List<String> lines) {
        for (String line : lines) {
            line = line.trim();
            String[] operationData = line.split(DELIMITER);
            String operation = operationData[OPERATION_POS];
            OperationHandler operationHandler =  operationHandlerStrategy.get(operation);
            if (operationHandler != null) {
                String fruitName = operationData[FRUIT_NAME_POS];
                int fruitsQuantity = Integer.parseInt(operationData[FRUITS_QUANTITY_POS]);
                operationHandler.handle(fruitName,fruitsQuantity);
            }
        }
    }
}
