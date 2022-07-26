package core.basesyntax.operations.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.operations.OperationHandler;

public class Purchase implements OperationHandler {
    @Override
    public void processLineData(String product, int quantity, FruitsDao fruitsDao) {
        fruitsDao.subtract(product, quantity);
    }
}
