package core.strategy.handler;

import core.model.Transaction;
import core.service.TransactionDao;

public class BalanceHandler extends OperationHandler {
    public BalanceHandler(TransactionDao transactionDao) {
        super(transactionDao);
    }
    
    @Override
    public void handle(Transaction transaction) {
        transactionDao.set(transaction.getType(), transaction.getQuantity());
    }
}
