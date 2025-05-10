package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import operation.handler.OperationHandler;
import operation.strategy.OperationStrategy;
import transaction.FruitTransaction;

public class ShopServiceImpl implements ShopService {
    private final Map<String, Integer> storage = new HashMap<>();
    private final OperationStrategy operation;

    public ShopServiceImpl(OperationStrategy operation) {
        this.operation = operation;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operation.getOperation(transaction.getOperation());
            if (handler == null) {
                throw new IllegalStateException("No handler found for operation");
            }
            handler.operation(transaction, storage);
        }
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }
}
