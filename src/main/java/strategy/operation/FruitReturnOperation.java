package strategy.operation;

import strategy.FruitStorageHandler;
import strategy.StorageHandler;

public class FruitReturnOperation implements OperationHandler<String,Integer> {
    private static final StorageHandler<String,Integer> STORAGE_HANDLER
            = new FruitStorageHandler();

    @Override
    public void doOperation(String fruit, Integer quantity) {
        Integer currentValue = STORAGE_HANDLER.getValue(fruit);
        if (currentValue == null) {
            throw new RuntimeException("Can't find this fruit: " + fruit);
        }
        int newValue = currentValue + quantity;
        STORAGE_HANDLER.put(fruit, newValue);
    }
}
