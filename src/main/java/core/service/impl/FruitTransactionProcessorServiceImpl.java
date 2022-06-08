package core.service.impl;

import core.service.FruitTransactionProcessorService;
import core.service.OperationHandlerStrategy;
import core.service.handlers.OperationHandler;
import java.util.List;

public class FruitTransactionProcessorServiceImpl implements FruitTransactionProcessorService {
    private static final int OPERATION_POS = 0;
    private static final int FRUIT_NAME_POS = 1;
    private static final int FRUITS_QUANTITY_POS = 2;
    private final OperationHandlerStrategy operationHandlerStrategy;

    public FruitTransactionProcessorServiceImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    public void fillStorage(List<String> lines) {
        for (String line : lines) {
            line = line.trim();
            String[] operationData = line.split(",");
            String operation = operationData[OPERATION_POS];
            OperationHandler operationHandler = operationHandlerStrategy.get(operation);
            if (operationHandler != null) {
                String fruitName = operationData[FRUIT_NAME_POS];
                int fruitsQuantity = Integer.parseInt(operationData[FRUITS_QUANTITY_POS]);
                operationHandler.handle(fruitName,fruitsQuantity);
            }
        }
    }
}
