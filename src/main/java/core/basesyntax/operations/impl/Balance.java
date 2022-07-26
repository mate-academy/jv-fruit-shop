package core.basesyntax.operations.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.operations.OperationHandler;

public class Balance implements OperationHandler {
    @Override
    public void processLineData(String product, int quantity, FruitsDao fruitsDao) {
        fruitsDao.add(product, quantity);
    }
}
