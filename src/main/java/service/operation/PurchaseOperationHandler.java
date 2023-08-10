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
        purchaseFruitDao.setFruitQuantity(fruit.getFruitName(),
                purchaseFruitDao.getFruitQuantity(fruit.getFruitName())
                        - fruit.getFruitQuantity());
    }
}
