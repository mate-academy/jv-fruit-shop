package strategy.operation;

import db.StorageDao;

public class FruitPurchaseOperation implements OperationHandler<String, Integer> {
    private final StorageDao<String, Integer> storageHandler;

    public FruitPurchaseOperation(StorageDao fruitStorageHandler) {
        storageHandler = fruitStorageHandler;
    }

    @Override
    public void doOperation(String fruit, Integer quantity) {
        Integer currentValue = storageHandler.getValue(fruit);
        if (currentValue == null) {
            throw new RuntimeException("Can't find this fruit: " + fruit);
        }
        if (quantity >= currentValue) {
            throw new RuntimeException("Can't subtract this count: " + quantity
                    + ". Avalible is: " + currentValue);
        }
        int newValue = currentValue - quantity;
        storageHandler.put(fruit, newValue);
    }
}
