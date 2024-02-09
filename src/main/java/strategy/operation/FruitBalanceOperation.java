package strategy.operation;

import strategy.FruitStorageHandler;
import strategy.StorageHandler;

public class FruitBalanceOperation implements OperationHandler<String, Integer> {
    private static StorageHandler<String, Integer> STORAGE_HANDLER = new FruitStorageHandler();

    @Override
    public void doOperation(String fruit, Integer quantity) {
        STORAGE_HANDLER.put(fruit, quantity);
    }
}
