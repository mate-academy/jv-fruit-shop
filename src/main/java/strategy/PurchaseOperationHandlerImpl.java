package strategy;

import model.Fruit;
import storage.Storage;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    @Override
    public void apply(Fruit fruit, int quantity) {
        if (Storage.data.get(fruit) - quantity < 0) {
            throw new RuntimeException("You can't bought this fruit");
        }
        Storage.data.put(fruit, Storage.data.get(fruit) - quantity);
    }
}
