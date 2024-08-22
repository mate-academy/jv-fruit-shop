package service.operation;

import dao.FruitDao;

public class BalanceOperation implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(String fruit, int quantity) {
        fruitDao.addBalance(fruit, quantity);
    }
}
