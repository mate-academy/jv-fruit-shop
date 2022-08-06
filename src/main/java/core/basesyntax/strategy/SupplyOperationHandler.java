package core.basesyntax.strategy;

import core.basesyntax.dao.Dao;
import core.basesyntax.dao.DaoHashMap;

public class SupplyOperationHandler implements OperationHandler {
    private final Dao dao;

    public SupplyOperationHandler(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void performOperation(String fruit, Integer quantity) {
        new DaoHashMap().add(fruit, dao.getQuantity(fruit) + quantity);
    }
}
