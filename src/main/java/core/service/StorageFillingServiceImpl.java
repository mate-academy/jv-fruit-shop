package core.service;

import java.util.List;

public class StorageFillingServiceImpl implements StorageFillingService {
    private final OperationHandlerStrategy operationHandlerStrategy;

    public StorageFillingServiceImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    public void fillStorage(List<String> fruitsOperations) {
        for (String fruitOperation : fruitsOperations) {
            try {
                fruitOperation = fruitOperation.trim();
                String[] operationData = fruitOperation.split(",");
                String operation = operationData[0];
                String fruitName = operationData[1];
                int fruitsQuantity = Integer.parseInt(operationData[2]);
                operationHandlerStrategy.get(operation).handle(fruitName,fruitsQuantity);
            } catch (NumberFormatException
                     | NullPointerException e) {
                continue;
            }
        }
    }
}
