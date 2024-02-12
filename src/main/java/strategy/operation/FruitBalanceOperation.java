package strategy.operation;

import db.StorageDao;

public class FruitBalanceOperation implements OperationHandler<String, Integer> {
    private final StorageDao<String, Integer> storageHandler;

    public FruitBalanceOperation(StorageDao fruitStorageHandler) {
        storageHandler = fruitStorageHandler;
    }

    @Override
    public void doOperation(String fruit, Integer quantity) {
        storageHandler.put(fruit, quantity);
    }
}
