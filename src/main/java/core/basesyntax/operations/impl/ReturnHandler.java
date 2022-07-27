package core.basesyntax.operations.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.operations.OperationHandler;

public class ReturnHandler implements OperationHandler {
    private final FruitsDao fruitsDao;

    public ReturnHandler(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void process(String product, int quantity) {
        fruitsDao.addProductQuantity(product, quantity);
    }
}
