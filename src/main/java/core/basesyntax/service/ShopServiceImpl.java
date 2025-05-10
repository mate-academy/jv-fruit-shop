package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationstrategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final Storage storage;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        this.storage = new Storage();
    }

    public ShopServiceImpl(OperationStrategy operationStrategy, Storage storage) {
        this.operationStrategy = operationStrategy;
        this.storage = storage;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy.applyOperation(transaction.getOperation(),
                    transaction.getFruit(), transaction.getQuantity()
            );
        }
    }

    @Override
    public Map<String, Integer> getStorage() {
        return storage.getAllFruits(); // Return a copy of the storage map
    }
}
