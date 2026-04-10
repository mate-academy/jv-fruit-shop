package core.strategy.handler;

import core.model.Transaction;
import core.service.TransactionDao;

public abstract class OperationHandler {
    protected final TransactionDao transactionDao;

    public OperationHandler(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    public abstract void handle(Transaction transaction);
}
