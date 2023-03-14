package strategy.activities;

import db.FruitStore;
import model.FruitTransaction;

public class SupplyHandler implements ActivitiesHandler {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        if (FruitStore.supplies.containsKey(fruitTransaction.getFruit())) {
            int quantity = FruitStore.supplies.get(fruitTransaction.getFruit())
                    + fruitTransaction.getQuantity();
            FruitStore.supplies.put(fruitTransaction.getFruit(), quantity);
        } else {
            FruitStore.supplies.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
