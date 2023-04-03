package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class AddOperationHandlerImpl implements OperationHandler {
    private final FruitDao fruitDao;

    public AddOperationHandlerImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void operationWithFruitTransaction(FruitTransaction fruitTransaction) {
        fruitDao.merge(
                fruitTransaction.getFruit(),
                fruitTransaction.getQuantity(),
                Integer::sum);
    }
}
