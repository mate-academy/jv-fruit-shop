package strategy.operation;

import dao.FruitShopDaoImpl;
import model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitShopDaoImpl fruitShopDao = new FruitShopDaoImpl();

    @Override
    public void execute(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        fruitShopDao.putBalanceStatistic(fruit, transaction.getQuantity());
    }
}
