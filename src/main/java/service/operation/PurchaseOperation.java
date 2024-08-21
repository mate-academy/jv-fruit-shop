package service.operation;

import dao.FruitDao;
import dao.FruitDaoImpl;

public class PurchaseOperation implements OperationHandler {
    private FruitDao fruitDao;

    public PurchaseOperation() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public void handle(String fruit, int quantity) {
        int balanceAfterPurchase = fruitDao.getFruitBalance(fruit) - quantity;
        if (balanceAfterPurchase >= 0) {
            fruitDao.updateBalanceOfFruit(fruit,balanceAfterPurchase);
        } else {
            throw new RuntimeException("We don't have enough " + fruit + "s");
        }
    }
}
