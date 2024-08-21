package service.operation;

import dao.FruitDao;
import dao.FruitDaoImpl;

public class BalanceOperation implements OperationHandler {
    private FruitDao fruitDao;

    public BalanceOperation() {
        this.fruitDao = new FruitDaoImpl();
    }

    @Override
    public void handle(String fruit, int quantity) {
        fruitDao.addBalanceOfFruit(fruit, quantity);
    }
}
