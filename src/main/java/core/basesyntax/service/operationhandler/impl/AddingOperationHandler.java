package core.basesyntax.service.operationhandler.impl;

import core.basesyntax.bd.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operationhandler.OperationHandler;

public class AddingOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public AddingOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction fruit) {
        if (fruitDao.get(fruit.getName()) == null) {
            fruitDao.add(fruit.getName(), fruit.getAmount());
        } else {
            fruitDao.add(fruit.getName(), fruitDao.getValue(fruit.getName())
                    + fruit.getAmount());
        }
    }
}
