package strategy.activities;

import db.FruitStore;
import model.FruitTransaction;

public class PurchaseHandler implements ActivitiesHandler {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        try {
            if (FruitStore.supplies.containsKey(fruitTransaction.getFruit())) {
                int quantity = FruitStore.supplies.get(fruitTransaction.getFruit())
                        - fruitTransaction.getQuantity();
                FruitStore.supplies.put(fruitTransaction.getFruit(), quantity);
            } else {
                FruitStore.supplies.put(fruitTransaction.getFruit(),
                        -fruitTransaction.getQuantity());
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("there are no such fruit in stock");
        }
    }
}
