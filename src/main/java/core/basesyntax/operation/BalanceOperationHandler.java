package core.basesyntax.operation;

import core.basesyntax.dao.Dao;
import core.basesyntax.dao.DaoHashMap;

public class BalanceOperationHandler implements OperationHandler {
    private final Dao dao;

    public BalanceOperationHandler(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void performOperation(String fruit, Integer quantity) {
        if (dao.getQuantity(fruit) > 0) {
            System.out.println("There are more the one of balance data on fruit " + fruit);
        }
        new DaoHashMap().add(fruit, quantity);
    }
}
