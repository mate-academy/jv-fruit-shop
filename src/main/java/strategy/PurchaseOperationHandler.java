package strategy;

import db.Storage;
import model.Fruit;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void process(Fruit fruit, Integer quantity) {
        Integer initialQuantity = Storage.storage.get(fruit);
        if (Storage.storage.get(fruit) == null) {
            throw new RuntimeException("No such product: " + fruit);
        }
        if (Storage.storage.get(fruit) - quantity < 0) {
            throw new RuntimeException("Not enough of " + fruit + "'s");
        }
        Storage.storage.put(fruit, initialQuantity - quantity);
    }
}
