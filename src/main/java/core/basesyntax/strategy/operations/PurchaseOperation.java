package core.basesyntax.strategy.operations;

import core.basesyntax.dao.FruitsDao;

public class PurchaseOperation implements OperationHandler {
    private FruitsDao fruitsDao;

    public PurchaseOperation(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void handle(String fruitName, int quantity) {
        int fruitQuantity = fruitsDao.getFruitQuantity(fruitName) - quantity;
        if (fruitQuantity < 0) {
            throw new RuntimeException("There are not enough fruits " + fruitName + "for selling");
        }
        fruitsDao.add(fruitName, fruitQuantity);
    }
}
