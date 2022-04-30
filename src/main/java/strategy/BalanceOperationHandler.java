package strategy;

import db.Storage;
import model.Fruit;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void process(Fruit fruit, Integer quantity) {
        Integer initialQuantity = Storage.STORAGE.get(fruit);
        Storage.STORAGE.put(fruit,
                initialQuantity == null
                ? quantity
                : initialQuantity + quantity);
    }
}
