package strategy.operation;

import dao.FruitShopDao;
import dao.FruitShopDaoImpl;
import model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitShopDao fruitShopDao = new FruitShopDaoImpl();

    @Override
    public void execute(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        fruitShopDao.putBalanceStatistic(fruit, fruitShopDao.getBalanceByFruit(fruit)
                + transaction.getQuantity());
    }
}
