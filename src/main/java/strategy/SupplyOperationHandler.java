package strategy;

import model.Fruit;
import storage.Storage;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void operation(Fruit fruit, Integer quantity) {
        Integer initialQuantity = Storage.STORAGE.get(fruit);
        Storage.STORAGE.put(fruit,
                initialQuantity == null
                        ? quantity
                        : initialQuantity + quantity);
    }
}
