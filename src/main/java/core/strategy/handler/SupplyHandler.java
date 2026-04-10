package core.strategy.handler;

import core.model.Transaction;
import core.service.TransactionDao;

public class SupplyHandler extends OperationHandler {
    public SupplyHandler(TransactionDao transactionDao) {
        super(transactionDao);
    }
    
    @Override
    public void handle(Transaction transaction) {
        transactionDao.add(transaction.getType(), transaction.getQuantity());
    }
}
