package core.basesyntax.model.strategy;

import core.basesyntax.dao.Dao;
import core.basesyntax.dao.DaoImpl;
import core.basesyntax.model.OperationHandler;

public class BalanceHandler implements OperationHandler {
    private final Dao dao = new DaoImpl();

    @Override
    public Integer apply(String fruitName, int amount) {
        return dao.put(fruitName, amount);
    }
}
