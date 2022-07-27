package core.basesyntax.operations.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.operations.OperationHandler;

public class BalanceHandler implements OperationHandler {
    private final FruitsDao fruitsDao;

    public BalanceHandler(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void process(String product, int quantity) {
        fruitsDao.addProduct(product, quantity);
    }
}
