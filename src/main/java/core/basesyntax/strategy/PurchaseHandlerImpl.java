package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;

public class PurchaseHandlerImpl implements OperationHandler {
    private final StorageDao dao;

    public PurchaseHandlerImpl(StorageDao dao) {
        this.dao = dao;
    }

    @Override
    public void apply(Fruit fruit, int quantity) {
        if (dao.get(fruit) - quantity < 0) {
            throw new RuntimeException("There are no products...");
        }
        dao.take(fruit, quantity);
    }
}
