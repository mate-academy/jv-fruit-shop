package service.strategy.impl;

import dao.FruitDao;
import model.Fruit;
import model.Transaction;
import service.strategy.TransactionHandler;

public class PurchaseHandler implements TransactionHandler {
    private final FruitDao fruitDao;

    public PurchaseHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(Transaction transaction) {
        Fruit fruit = transaction.getFruit();
        Integer fruitQuantity = fruitDao.getQuantityOf(fruit);
        Integer transactionFruitQuantity = transaction.getQuantity();
        if (fruitQuantity < transactionFruitQuantity) {
            throw new RuntimeException("Not enough " + fruit.getName() + "s in stock.");
        }
        fruitDao.update(fruit, fruitQuantity - transactionFruitQuantity);
    }
}
