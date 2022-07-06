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
        boolean fruitNoFound = Storage.leftovers.entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(transaction.getFruit()))
                .peek(entry -> entry.setValue(entry.getValue() + handler.getSign()
                        * transaction.getQuantity()))
                .findFirst()
                .isEmpty();
        if (fruitNoFound) {
            Storage.leftovers.put(transaction.getFruit(), handler.getSign()
                    * transaction.getQuantity());
        }
        return new HashMap<>(Storage.leftovers);
    }

    @Override
    public Map<String, Integer> getLeftovers() {
        return Storage.leftovers;
    }
}
