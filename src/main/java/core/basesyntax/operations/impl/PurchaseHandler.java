package core.basesyntax.operations.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.operations.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    private final FruitDao fruitsDao;

    public PurchaseHandler(FruitDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void process(String product, int quantity) {
        fruitsDao.subtract(product, quantity);
    }
}
