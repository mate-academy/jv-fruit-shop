package strategy.operation;

import db.StorageDao;

public class FruitReturnOperation implements OperationHandler<String,Integer> {
    private final StorageDao<String, Integer> storageHandler;

    public FruitReturnOperation(StorageDao fruitStorageHandler) {
        storageHandler = fruitStorageHandler;
    }

    @Override
    public void doOperation(String fruit, Integer quantity) {
        Integer currentValue = storageHandler.getValue(fruit);
        if (currentValue == null) {
            throw new RuntimeException("Can't find this fruit: " + fruit);
        }
        int newValue = currentValue + quantity;
        storageHandler.put(fruit, newValue);
    }
}
