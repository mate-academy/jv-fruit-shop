package strategy;

import dao.FruitStorageDao;
import model.Fruit;

public class ReturnOperationStrategy implements OperationHandler {
    @Override
    public void handle(Fruit fruit, FruitStorageDao storage) {
        storage.add(fruit.getName(), fruit.getQuantity());
    }
}
