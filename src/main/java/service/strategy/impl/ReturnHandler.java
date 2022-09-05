package service.strategy.impl;

import dao.FruitDao;
import model.Fruit;
import model.Transaction;
import service.strategy.TransactionHandler;

public class ReturnHandler implements TransactionHandler {
    private final FruitDao fruitDao;

    public ReturnHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        fruitDao.update(fruit, fruitDao.getQuantityOf(fruit) + transaction.getQuantity());
    }
}
