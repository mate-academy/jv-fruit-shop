package core.basesyntax.strategy.impl;

import core.basesyntax.dao.Dao;
import core.basesyntax.strategy.OperationHandler;

public class BalanceHandler implements OperationHandler {
    private final Dao dao;

    public BalanceHandler(Dao dao) {
        this.dao = dao;
    }

    @Override
    public Integer apply(String fruitName, int amount) {
        return dao.put(fruitName, amount);
    }
}
