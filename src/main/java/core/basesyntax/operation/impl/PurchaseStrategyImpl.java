package core.basesyntax.operation.impl;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

public class PurchaseStrategyImpl implements OperationHandler {

    @Override
    public void updateNumberOfFruit(FruitTransaction fruitTransaction) {
        FruitDaoImpl fruitDao = new FruitDaoImpl();
        int newFruitQuantity =
                fruitDao.get(fruitTransaction.getFruit()) - fruitTransaction.getQuantity();
        fruitDao.add(fruitTransaction.getFruit(), newFruitQuantity);
    }
}
