package core.basesyntax.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {

    private final OperationStrategy strategy;
    private final Map<String, Integer> storage = new HashMap<>();

    public ShopServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {

        for (FruitTransaction tx : transactions) {

            OperationHandler handler =
                    strategy.getHandler(tx.getOperation());

            handler.process(tx, storage);
        }
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }
}
