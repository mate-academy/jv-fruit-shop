package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import core.basesyntax.dao.FruitDao;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handler(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        fruitDao.addFruit(fruit, fruitDao.getQuantity(fruit) + transaction.getQuantity());
    }
}
