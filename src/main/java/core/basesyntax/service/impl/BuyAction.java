package core.basesyntax.service.impl;

import core.basesyntax.Store;
import core.basesyntax.Transaction;
import core.basesyntax.service.ActionsWithFruits;

public class BuyAction implements ActionsWithFruits {
    @Override
    public void actionWithStorage(Transaction transaction) {
        String fruit = transaction.getFruit();
        String quantity = transaction.getQuantity();
        if (Store.fruits.get(fruit) < Integer.parseInt(quantity)) {
            throw new RuntimeException("Sorry, but we don't have that many");
        }
        Store.fruits.put(fruit, Store.fruits.get(fruit) - Integer.parseInt(quantity));
    }
}
