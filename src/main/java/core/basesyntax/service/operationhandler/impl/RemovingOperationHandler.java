package core.basesyntax.service.operationhandler.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.operationhandler.OperationHandler;

public class RemovingOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public RemovingOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(TransactionDto transaction) {
        Fruit fruit = transaction.getFruit();
        if (fruitDao.get(fruit) < transaction.getAmount()) {
            throw new RuntimeException("Invalid operation, not enough fruits to buy");
        }
        fruitDao.add(fruit,
                fruitDao.get(transaction.getFruit()) - transaction.getAmount());
    }
}
