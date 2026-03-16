package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy strategy;
    private final Map<String, Integer> storage = new HashMap<>();

    public ShopServiceImpl(OperationStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy);
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new IllegalArgumentException("transactions is null");
        }
        for (FruitTransaction t : transactions) {
            OperationHandler handler = strategy.get(t.getOperation());
            handler.handle(t, storage);
        }
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }
}
