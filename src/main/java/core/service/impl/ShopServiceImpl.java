package core.service.impl;

import core.model.Transaction;
import core.service.ShopService;
import core.service.TransactionDao;
import core.strategy.OperationStrategy;
import core.strategy.handler.OperationHandler;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy strategy;
    private final TransactionDao transactionDao;
    
    public ShopServiceImpl(OperationStrategy strategy, TransactionDao transactionDao) {
        this.strategy = strategy;
        this.transactionDao = transactionDao;
    }
    
    @Override
    public void process(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            OperationHandler handler = strategy.getOperationHandler(transaction.getOperation());
            handler.handle(transaction);
        }
    }
    
    @Override
    public Map<String, Integer> getData() {
        return transactionDao.getAll();
    }
}
