package strategy.operation;

import dao.FruitShopDaoImpl;
import exception.FruitShopException;
import model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitShopDaoImpl fruitShopDao = new FruitShopDaoImpl();

    @Override
    public void execute(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int balance = fruitShopDao.getBalanceByFruit(fruit) - transaction.getQuantity();
        if (balance > 0) {
            fruitShopDao.putBalanceStatistic(fruit, balance);
        } else {
            throw new FruitShopException("Quantity can't be bigger then balance");
        }
    }
}
