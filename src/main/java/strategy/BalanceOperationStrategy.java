package strategy;

import dao.FruitStorageDao;
import model.Fruit;

public class BalanceOperationStrategy implements OperationHandler {
    @Override
    public void handle(Fruit fruit, FruitStorageDao storage) {
        storage.set(fruit.getName(), fruit.getQuantity());
    }
}
