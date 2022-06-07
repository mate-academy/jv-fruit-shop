package core.service;

import java.util.List;

public class StorageFillingService {
    private final UpdateFruitsStrategy updateFruitsStrategy;

    public StorageFillingService(UpdateFruitsStrategy updateFruitsStrategy) {
        this.updateFruitsStrategy = updateFruitsStrategy;
    }

    public void fillStorage(List<String> fruitsOperations) {
        for (String fruitOperation : fruitsOperations) {
            try {
                fruitOperation = fruitOperation.trim();
                String[] operationData = fruitOperation.split(",");
                String operation = operationData[0];
                String fruitName = operationData[1];
                int fruitQuantity = Integer.parseInt(operationData[2]);
                updateFruitsStrategy.get(operation).doOperation(fruitName,fruitQuantity);
            } catch (NumberFormatException
                     | NullPointerException e) {
                continue;
            }
        }
    }
}
