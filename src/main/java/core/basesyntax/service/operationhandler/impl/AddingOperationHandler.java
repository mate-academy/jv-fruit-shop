package core.basesyntax.service.operationhandler.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.operationhandler.OperationHandler;

public class AddingOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public AddingOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(TransactionDto transaction) {
        Fruit fruit = transaction.getFruit();
        if (!fruitDao.contains(fruit)) {
            fruitDao.add(fruit, transaction.getAmount());
        } else {
            fruitDao.add(fruit,
                    fruitDao.get(fruit) + transaction.getAmount());
        }
    }
}
