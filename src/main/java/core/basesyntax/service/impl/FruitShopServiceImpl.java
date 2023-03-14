package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> process(List<FruitTransaction> parsed) {
        parsed.forEach(t -> operationStrategy.get(t.getOperation()).activity(t));
        return Storage.getMap();
    }
}
