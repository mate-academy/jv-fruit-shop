package core.basesyntax.operation.impl;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

public class BalanceHandlerImpl implements OperationHandler {
    private final FruitDaoImpl fruitDao = new FruitDaoImpl();

    @Override
    public void updateNumberOfFruit(FruitTransaction fruitTransaction) {
        fruitDao.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
