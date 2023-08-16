package strategy;

import dao.FruitStorageDao;
import model.Fruit;

public class PurchaseOperationStrategy implements OperationHandler {
    @Override
    public void handle(Fruit fruit, FruitStorageDao storage) {
        storage.remove(fruit.getName(), fruit.getQuantity());
    }
}
