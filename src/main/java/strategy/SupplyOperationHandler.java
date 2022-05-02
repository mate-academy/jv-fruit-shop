package strategy;

import model.Fruit;
import storage.Storage;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void apply(Fruit fruit, int quantity) {
        Storage.data.put(fruit, Storage.data.get(fruit) + quantity);
    }
}
