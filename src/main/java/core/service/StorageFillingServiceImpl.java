package core.service;

import java.util.List;

public class StorageFillingServiceImpl implements StorageFillingService {
    private final OperationHandlerStrategy operationHandlerStrategy;
    private final int OPERATION_POS = 0;
    private final int FRUIT_NAME_POS = 1;
    private final int FRUITS_QUANTITY_POS = 2;

    public StorageFillingServiceImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    public void fillStorage(List<String> fruitsOperations) {
        for (String fruitOperation : fruitsOperations) {
            try {
                fruitOperation = fruitOperation.trim();
                String[] operationData = fruitOperation.split(",");
                String operation = operationData[OPERATION_POS];
                String fruitName = operationData[FRUIT_NAME_POS];
                int fruitsQuantity = Integer.parseInt(operationData[FRUITS_QUANTITY_POS]);
                operationHandlerStrategy.get(operation).handle(fruitName,fruitsQuantity);
            } catch (NumberFormatException
                     | NullPointerException e) {
                continue;
            }
        }
    }
}
