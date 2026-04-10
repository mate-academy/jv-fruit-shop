package core.strategy.handler;

import core.model.Transaction;
import core.service.TransactionDao;

public class PurchaseHandler extends OperationHandler {
    public PurchaseHandler(TransactionDao transactionDao) {
        super(transactionDao);
    }
    
    @Override
    public void handle(Transaction transaction) {
        transactionDao.subtract(transaction.getType(), transaction.getQuantity());
    }
}
