package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class ReturnOperationHandlerImpl implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnOperationHandlerImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void operationWithFruitTransaction(FruitTransaction fruitTransaction) {
        fruitDao.getAll().merge(
                fruitTransaction.getFruit(),
                fruitTransaction.getQuantity(),
                Integer::sum);
    }
}
