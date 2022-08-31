package core.basesyntax.operations.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.operations.OperationHandler;

public class SupplyHandler implements OperationHandler {
    private final FruitDao fruitsDao;

    public SupplyHandler(FruitDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void process(String product, int quantity) {
        fruitsDao.add(product, quantity);
    }
}
