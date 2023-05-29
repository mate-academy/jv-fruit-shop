package strategy;

import db.Storage;
import model.Fruit;

public class BalanceOperation implements OperationsStrategy {
    @Override
    public void handle(Fruit fruit) {
        Storage.storage.put(fruit.getFruit(), fruit.getQuantity());
    }
}
