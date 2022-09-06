package service.impl;

import dao.FruitDao;
import dao.impl.FruitDaoImpl;
import model.Transaction;
import service.TransactionExecutor;
import service.strategy.impl.AddHandler;
import service.strategy.impl.BalanceHandler;
import service.strategy.impl.PurchaseHandler;

public class TransactionExecutorImpl implements TransactionExecutor {
    @Override
    public void execute(Transaction transaction) {
        FruitDao fruitDao = new FruitDaoImpl();
        switch (transaction.getOperation()) {
            case BALANCE:
                new BalanceHandler(fruitDao).execute(transaction);
                break;
            case PURCHASE:
                new PurchaseHandler(fruitDao).execute(transaction);
                break;
            case SUPPLY:
            case RETURN:
                new AddHandler(fruitDao).execute(transaction);
                break;
            default:
        }
    }
}
