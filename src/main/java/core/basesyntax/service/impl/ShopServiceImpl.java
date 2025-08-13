package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        if (operationStrategy == null) {
            throw new IllegalArgumentException("OperationStrategy cannot be null");
        }
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new IllegalArgumentException("Transactions list cannot be null");
        }

        for (FruitTransaction transaction : transactions) {
            if (transaction == null) {
                throw new IllegalArgumentException("Transaction cannot be null");
            }
            try {
                OperationHandler handler = operationStrategy.get(transaction.getOperation());
                handler.handle(transaction, Storage.storage);
            } catch (Exception e) {
                throw new RuntimeException("Failed to process transaction: " + transaction, e);
            }
        }
    }

    @Override
    public Map<String, Integer> getStorage() {
        return Collections.unmodifiableMap(Storage.storage);
    }
}
