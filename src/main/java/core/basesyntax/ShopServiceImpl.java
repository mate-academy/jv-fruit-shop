package core.basesyntax;

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
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            if (transaction.getOperation() == null) {
                throw new IllegalArgumentException("Unknown operation: null");
            }

            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            if (handler == null) {
                throw new IllegalArgumentException(
                        "Unknown operation: " + transaction.getOperation());
            }

            try {
                handler.handle(transaction, storage);
            } catch (IllegalArgumentException e) {
                throw e;
            }
        }
    }

    @Override
    public Map<String, Integer> getStorage() {
        return new HashMap<>(storage); // Ensure a copy is returned to prevent external modification
    }
}
