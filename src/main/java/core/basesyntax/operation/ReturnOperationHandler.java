package core.basesyntax.operation;

import core.basesyntax.dao.Dao;
import core.basesyntax.dao.DaoHashMap;

public class ReturnOperationHandler implements OperationHandler {
    private final Dao dao;

    public ReturnOperationHandler(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void performOperation(String fruit, Integer quantity) {
        new DaoHashMap().add(fruit, dao.getQuantity(fruit) + quantity);
    }
}
