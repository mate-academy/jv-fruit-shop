package core.basesyntax.operation.impl;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

public class SuppliersStrategyImpl implements OperationHandler {

    @Override
    public void updateNumberOfFruit(FruitTransaction fruitTransaction) {
        FruitDaoImpl fruitDao = new FruitDaoImpl();

        int currentQuantity = fruitDao.contains(fruitTransaction.getFruit())
                ? fruitDao.get(fruitTransaction.getFruit()) : 0;

        int newQuantity = currentQuantity + fruitTransaction.getQuantity();

        fruitDao.add(fruitTransaction.getFruit(), newQuantity);
    }
}
