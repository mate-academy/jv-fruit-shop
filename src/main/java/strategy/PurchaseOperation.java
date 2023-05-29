package strategy;

import db.Storage;
import model.Fruit;

public class PurchaseOperation implements OperationsStrategy {
    @Override
    public void handle(Fruit fruit) {
        Integer fruitBalance = Storage.storage.getOrDefault(fruit.getFruit(), 0);
        if (fruitBalance >= fruit.getQuantity()) {
            Storage.storage.put(fruit.getFruit(), fruitBalance - fruit.getQuantity());
        } else {
            throw new RuntimeException("There isn't or enough "
                    + fruit.getFruit() + " in fruit shop");
        }
    }
}
