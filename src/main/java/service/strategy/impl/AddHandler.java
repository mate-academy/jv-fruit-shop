package service.strategy.impl;

import dao.FruitDao;
import model.Fruit;
import model.Transaction;
import service.strategy.TransactionHandler;

public class AddHandler implements TransactionHandler {
    private final FruitDao fruitDao;

    public AddHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        fruitDao.update(fruit, fruitDao.getQuantity(fruit) + transaction.getQuantity());
    }
}
