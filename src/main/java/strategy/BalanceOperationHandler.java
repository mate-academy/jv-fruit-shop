package strategy;

import model.Fruit;
import storage.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(Fruit fruit, int quantity) {
        Storage.data.put(fruit, quantity);
    }
}
