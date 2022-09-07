package service.impl;

import dao.FruitDao;
import dao.impl.FruitDaoImpl;
import java.util.HashMap;
import java.util.Map;
import model.Transaction;
import service.TransactionExecutor;
import service.strategy.TransactionHandler;
import service.strategy.impl.AddHandler;
import service.strategy.impl.BalanceHandler;
import service.strategy.impl.PurchaseHandler;

public class TransactionExecutorImpl implements TransactionExecutor {
    private final FruitDao fruitDao = new FruitDaoImpl();
    private final Map<Transaction.Operation, TransactionHandler> handlerMap = new HashMap<>() {
        {
            put(Transaction.Operation.BALANCE, new BalanceHandler(fruitDao));
            put(Transaction.Operation.PURCHASE, new PurchaseHandler(fruitDao));
            put(Transaction.Operation.SUPPLY, new AddHandler(fruitDao));
            put(Transaction.Operation.RETURN, new AddHandler(fruitDao));
        }
    };

    @Override
    public void execute(Transaction transaction) {
        handlerMap.get(transaction.getOperation()).execute(transaction);
    }
}
