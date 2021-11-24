package core.basesyntax.model.strategy;

import core.basesyntax.dao.Dao;
import core.basesyntax.dao.DaoImpl;
import core.basesyntax.model.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    private final Dao dao = new DaoImpl();

    @Override
    public Integer apply(String fruitName, int amount) {
        int newAmount = dao.get(fruitName) - amount;
        if (newAmount < 0) {
            throw new RuntimeException("Not enough " + fruitName);
        }
        return dao.put(fruitName, newAmount);
    }
}
