package service.strategy.impl;

import dao.FruitDao;
import model.Transaction;
import service.strategy.TransactionHandler;

public class BalanceHandler implements TransactionHandler {
    private final FruitDao fruitDao;

    public BalanceHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(Transaction transaction) {
        fruitDao.update(transaction.getFruit(), transaction.getQuantity());
    }
}
