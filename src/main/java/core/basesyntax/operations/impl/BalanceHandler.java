package core.basesyntax.operations.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.operations.OperationHandler;

public class BalanceHandler implements OperationHandler {
    private final FruitDao fruitsDao;

    public BalanceHandler(FruitDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void process(String product, int quantity) {
        fruitsDao.set(product, quantity);
    }
}
