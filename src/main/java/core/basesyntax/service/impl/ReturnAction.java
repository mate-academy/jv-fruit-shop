package core.basesyntax.service.impl;

import core.basesyntax.Store;
import core.basesyntax.Transaction;
import core.basesyntax.service.ActionsWithFruits;

public class ReturnAction implements ActionsWithFruits {
    @Override
    public void applyAction(Transaction transaction) {
        String fruit = transaction.getFruit();
        String quantity = transaction.getQuantity();
        if (Integer.parseInt(quantity) < 0) {
            throw new RuntimeException("Something went wrong. Quantity can't be negative!");
        }
        Store.fruits.merge(fruit, Integer.parseInt(quantity), (oldVal, newVal) -> oldVal + newVal);
    }
}
