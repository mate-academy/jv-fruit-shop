package core.db;

import core.service.OperationHandler;
import core.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class StorageServiceImpl implements StorageService<FruitTransaction> {
    private final OperationStrategy strategy;

    public StorageServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Map<String, Integer> addTransaction(FruitTransaction transaction) {
        OperationHandler handler = strategy.getOperationHandler(transaction.getOperation());
        handler.addTransaction(transaction, this);
        return new HashMap<>(Storage.fruitsMap);
    }

    @Override
    public Map<String, Integer> getLeftovers() {
        return Storage.fruitsMap;
    }
}
