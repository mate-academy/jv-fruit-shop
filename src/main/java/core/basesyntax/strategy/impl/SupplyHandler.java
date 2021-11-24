package core.basesyntax.strategy.impl;

import core.basesyntax.dao.Dao;
import core.basesyntax.strategy.OperationHandler;

public class SupplyHandler implements OperationHandler {
    private final Dao dao;

    public SupplyHandler(Dao dao) {
        this.dao = dao;
    }

    @Override
    public Integer apply(String fruitName, int amount) {
        int newAmount = dao.get(fruitName) + amount;
        return dao.put(fruitName, newAmount);
    }
}
