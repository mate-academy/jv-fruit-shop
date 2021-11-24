package core.basesyntax.strategy.impl;

import core.basesyntax.dao.Dao;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    private final Dao dao;

    public PurchaseHandler(Dao dao) {
        this.dao = dao;
    }

    @Override
    public Integer apply(String fruitName, int amount) {
        int newAmount = dao.get(fruitName) - amount;
        if (newAmount < 0) {
            throw new RuntimeException("Not enough " + fruitName);
        }
        return dao.put(fruitName, newAmount);
    }
}
