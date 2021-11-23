package core.basesyntax.service.operationhandler.impl;

import core.basesyntax.bd.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operationhandler.OperationHandler;

public class AddingOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public AddingOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction fruit) {
        Fruit fruitFromTransaction = fruit.getFruit();
        if (fruitDao.getKey(fruitFromTransaction) == null) {
            fruitDao.add(fruitFromTransaction, fruit.getAmount());
        } else {
            fruitDao.add(fruitFromTransaction,
                    fruitDao.getValue(fruitFromTransaction) + fruit.getAmount());
        }
    }
}
