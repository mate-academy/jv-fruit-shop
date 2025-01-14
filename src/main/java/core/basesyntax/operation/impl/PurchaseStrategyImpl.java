package core.basesyntax.operation.impl;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

public class PurchaseStrategyImpl implements OperationHandler {

    @Override
    public void updateNumberOfFruit(FruitTransaction fruitTransaction) {
        FruitDaoImpl fruitDao = new FruitDaoImpl();
        if (fruitDao.contains(fruitTransaction.getFruit())) {
            int newFruitQuantity =
                    fruitDao.get(fruitTransaction.getFruit()) - fruitTransaction.getQuantity();
            if (newFruitQuantity < 0) {
                throw new IllegalArgumentException("Not enough " + fruitTransaction.getFruit()
                        + " in stock");
            }
            fruitDao.add(fruitTransaction.getFruit(), newFruitQuantity);
        } else {
            throw new IllegalArgumentException("Can't find any " + fruitTransaction.getFruit());
        }
    }
}
