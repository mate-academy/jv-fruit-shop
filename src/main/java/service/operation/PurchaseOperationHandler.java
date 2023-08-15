package service.operation;

import dao.FruitDao;
import model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitDao purchaseFruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        purchaseFruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruit) {
        if (purchaseFruitDao.getFruitQuantity(fruit.getFruitName()) > fruit.getFruitQuantity()) {
            purchaseFruitDao.setFruitQuantity(fruit.getFruitName(),
                    purchaseFruitDao.getFruitQuantity(fruit.getFruitName())
                            - fruit.getFruitQuantity());
        } else {
            throw new RuntimeException("Balance of " + fruit.getFruitName()
                    + " is negative " + purchaseFruitDao.getFruitQuantity(fruit.getFruitName()));
        }
    }
}
