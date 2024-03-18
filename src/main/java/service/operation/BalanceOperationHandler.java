package service.operation;

import dao.FruitDao;
import model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitDao balanceFruitDao;

    public BalanceOperationHandler(FruitDao fruitDao) {
        balanceFruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruit) {
        balanceFruitDao.setFruitQuantity(fruit.getFruitName(), fruit.getFruitQuantity());
    }
}
