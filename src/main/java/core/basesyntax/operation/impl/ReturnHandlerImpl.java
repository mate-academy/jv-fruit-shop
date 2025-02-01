package core.basesyntax.operation.impl;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

public class ReturnHandlerImpl implements OperationHandler {
    private final FruitDaoImpl fruitDao = new FruitDaoImpl();

    @Override
    public void updateNumberOfFruit(FruitTransaction fruitTransaction) {
        int currentQuantity = fruitDao.contains(fruitTransaction.getFruit())
                ? fruitDao.get(fruitTransaction.getFruit()) : 0;

        int newQuantity = currentQuantity + fruitTransaction.getQuantity();

        fruitDao.add(fruitTransaction.getFruit(), newQuantity);
    }
}
