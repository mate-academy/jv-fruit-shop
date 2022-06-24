package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.dao.ShopDao;

public abstract class OperationHandler {
    protected final ShopDao dao;

    public OperationHandler(ShopDao dao) {
        this.dao = dao;
    }

    public abstract void process(Operation operation);

    protected boolean isFruitValid(String fruitName) {
        if (!dao.getAll().containsKey(fruitName)) {
            throw new RuntimeException("Unknown fruit: " + fruitName);
        }
        return true;
    }
}
