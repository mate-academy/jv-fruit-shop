package core.basesyntax.servise;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.servise.operation.OperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final Map<String, Integer> storage = new HashMap<>(); // Хранилище фруктов

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.get(transaction.getOperation());
            String fruit = transaction.getFruit();
            int quantity = transaction.getQuantity();

            handler.apply(fruit, quantity, storage);
        }
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }
}
