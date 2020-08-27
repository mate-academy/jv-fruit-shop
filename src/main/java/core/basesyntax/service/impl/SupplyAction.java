package core.basesyntax.service.impl;

import core.basesyntax.Store;
import core.basesyntax.Transaction;
import core.basesyntax.service.ActionsWithFruits;

public class SupplyAction implements ActionsWithFruits {
    @Override
    public void applyAction(Transaction transaction) {
        String fruit = transaction.getFruit();
        String quantity = transaction.getQuantity();
        if (Integer.parseInt(quantity) < 0) {
            throw new RuntimeException("Something went wrong. Quantity can't be negative!");
        }
        if (Store.fruits.containsKey(fruit)) {
            Store.fruits.put(fruit, Store.fruits.get(fruit) + Integer.parseInt(quantity));
        } else {
            Store.fruits.put(fruit, Integer.parseInt(quantity));
        }
    }
}
