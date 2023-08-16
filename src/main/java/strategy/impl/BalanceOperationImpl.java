package strategy.impl;

import dao.Fruit;
import dao.FruitDao;
import service.impl.FruitServiceImpl;
import strategy.OperationHandler;

public class BalanceOperationImpl implements OperationHandler {
    private FruitDao fruitDao;

    public BalanceOperationImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(String name, int quantity) {
        Fruit fruit = new Fruit(name, quantity);
        fruitDao.add(fruit);
    }

    @Override
    public void handle(FruitServiceImpl.Transaction transaction) {

    }
}
