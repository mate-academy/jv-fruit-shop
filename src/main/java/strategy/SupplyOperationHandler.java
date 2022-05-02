package strategy;

import db.Storage;
import model.Fruit;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void process(Fruit fruit, Integer quantity) {
        Integer initialQuantity = Storage.storage.get(fruit);
        Storage.storage.put(fruit,
                initialQuantity == null
                        ? quantity
                        : initialQuantity + quantity);
    }
}
