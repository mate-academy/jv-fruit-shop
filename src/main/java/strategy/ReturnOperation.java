package strategy;

import db.Storage;
import model.Fruit;

public class ReturnOperation implements OperationsStrategy {
    @Override
    public void handle(Fruit fruit) {
        Integer fruitBalance = Storage.storage.getOrDefault(fruit.getFruit(), 0);
        Storage.storage.put(fruit.getFruit(), fruitBalance + fruit.getQuantity());
    }
}
