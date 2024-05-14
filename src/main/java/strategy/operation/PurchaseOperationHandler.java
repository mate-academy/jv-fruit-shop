package strategy.operation;

import dao.FruitShopDaoImpl;
import exception.FruitShopException;
import model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitShopDaoImpl fruitShopDao = new FruitShopDaoImpl();

    @Override
    public void execute(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int newBalance = fruitShopDao.getBalanceByFruit(fruit) - transaction.getQuantity();
        if (newBalance <= 0) {
            throw new FruitShopException("Not enough in storage: " + newBalance);
        }
        fruitShopDao.putBalanceStatistic(fruit, newBalance);
    }
}
