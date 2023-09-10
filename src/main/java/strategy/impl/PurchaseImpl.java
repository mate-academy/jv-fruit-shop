package strategy.impl;

import db.Warehouse;
import strategy.Purchase;

public class PurchaseImpl implements Purchase {

    @Override
    public void subtract(String fruit, int quantity) {
        int actual = Warehouse.getStorage().get(Warehouse.TypeFruit.valueOf(fruit));
        int subtraction = actual - quantity;
        if (subtraction < 0) {
            throw new RuntimeException("The storage of " + fruit + "can't be negative."
                    + " If it equals " + actual + " we can't purchased " + quantity);
        }
        Warehouse.getStorage().put(Warehouse.TypeFruit.valueOf(fruit), subtraction);
    }
}
