package core.basesyntax.operation;

import core.basesyntax.dao.FruitDao;

public class PurchaseOperationHandler implements OperationHandler {
    FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void doOperation(String fruitName, int quantity) {
        int balanceValue = fruitDao.get(fruitName);
        fruitDao.put(fruitName, balanceValue - quantity);
    }
}
