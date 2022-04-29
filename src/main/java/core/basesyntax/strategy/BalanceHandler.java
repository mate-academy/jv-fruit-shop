package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;

public class BalanceHandler implements OperationHandler {
    private final StorageDao dao;

    public BalanceHandler(StorageDao dao) {
        this.dao = dao;
    }

    @Override
    public void apply(Fruit fruit, int quantity) {
        dao.add(fruit, quantity);
    }
}
