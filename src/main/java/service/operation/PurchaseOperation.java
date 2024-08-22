package service.operation;

import dao.FruitDao;
import dao.FruitDaoImpl;

public class PurchaseOperation implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(String fruit, int quantity) {
        int balanceAfterPurchase = fruitDao.getBalance(fruit) - quantity;
        if (balanceAfterPurchase >= 0) {
            fruitDao.updateBalance(fruit,balanceAfterPurchase);
        } else {
            throw new RuntimeException(String.format("You wanted to buy %d %ss " +
                    "but available only %d %ss",quantity, fruit,fruitDao.getBalance(fruit),fruit
            ));
        }
    }
}
