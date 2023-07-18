package strategy;

import dao.FruitStorageDao;
import model.Fruit;

public class SupplyOperationStrategy implements OperationHandler {
    @Override
    public void handle(Fruit fruit, FruitStorageDao storage) {
        storage.add(fruit.getName(), fruit.getQuantity());
    }
}
