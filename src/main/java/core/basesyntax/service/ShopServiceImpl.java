package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final Map<String, Integer> inventory = new HashMap<>();

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getHandler(
                    transaction.getOperation());
            if (handler == null) {
                throw new IllegalArgumentException(
                        "No handler found for operation: "
                                + transaction.getOperation());
            }
            handler.handle(inventory, transaction);
        }
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}
