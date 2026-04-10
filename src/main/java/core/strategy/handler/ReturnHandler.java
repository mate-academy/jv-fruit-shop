package core.strategy.handler;

import core.model.Transaction;
import core.service.TransactionDao;

public class ReturnHandler extends OperationHandler {
    public ReturnHandler(TransactionDao transactionDao) {
        super(transactionDao);
    }
    
    @Override
    public void handle(Transaction transaction) {
        transactionDao.add(transaction.getType(), transaction.getQuantity());
    }
}
