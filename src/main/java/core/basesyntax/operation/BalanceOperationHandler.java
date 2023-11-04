package core.basesyntax.operation;

import core.basesyntax.dao.FruitDao;

public class BalanceOperationHandler implements OperationHandler {
    FruitDao fruitDao;

    public BalanceOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void doOperation(String fruitName, int quantity) {
        fruitDao.put(fruitName, quantity);
    }
}
