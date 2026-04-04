package core.service;

import core.model.Transaction;
import core.service.handler.OperationHandler;
import core.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final Map<String, Integer> storage = new HashMap<>();
    
    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }
    @Override
    public void process(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.applyOperation(transaction, storage);
        }
    }
    @Override
    public Map<String, Integer> getStorage() {
        return storage;
    }
}
