package core.basesyntax.operations.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.operations.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    private final FruitsDao fruitsDao;

    public PurchaseHandler(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void process(String product, int quantity) {
        fruitsDao.subtract(product, quantity);
    }
}
