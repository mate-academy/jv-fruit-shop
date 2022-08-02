package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy strategy;

    public FruitShopServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler
                    = strategy.get(transaction.getOperation());
            handler.handle(transaction);
        }
    }

    @Override
    public Map<String, Integer> getAll() {
        Map<String, Integer> content = new HashMap<>();
        for (Fruit fruit : Storage.fruits) {
            content.put(fruit.getName(), fruit.getAmount());
        }
        return content;
    }
}
