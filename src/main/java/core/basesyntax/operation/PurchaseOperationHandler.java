package core.basesyntax.operation;

import core.basesyntax.dao.FruitDao;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void doOperation(String fruitName, int quantity) {
        int balanceValue = fruitDao.get(fruitName);
        if (quantity <= balanceValue) {
            fruitDao.put(fruitName, balanceValue - quantity);
        } else {
            throw new RuntimeException("Value of resulting balance can't be negative. Fruit: "
                    + fruitName + ", balance = " + balanceValue + ", purchase = " + quantity);
        }
    }
}
