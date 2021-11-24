package core.basesyntax.strategy.impl;

import core.basesyntax.dao.Dao;
import core.basesyntax.strategy.OperationHandler;

public class ReturnHandler implements OperationHandler {
    private final Dao dao;

    public ReturnHandler(Dao dao) {
        this.dao = dao;
    }

    @Override
    public Integer apply(String fruitName, int amount) {
        int newAmount = dao.get(fruitName) + amount;
        return dao.put(fruitName, newAmount);
    }
}
