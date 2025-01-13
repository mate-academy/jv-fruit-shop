package core.basesyntax.operation.impl;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

public class BalanceStrategyImpl implements OperationHandler {
    @Override
    public void updateNumberOfFruit(FruitTransaction fruitTransaction) {
        FruitDaoImpl fruitDao = new FruitDaoImpl();
        fruitDao.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
