package core.basesyntax.impl;

import core.basesyntax.dao.Storage;
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
    public Map<String, Integer> report(List<FruitTransaction> parsed) {
        if (parsed == null) {
            throw new RuntimeException("None of the arguments must be null");
        }
        parsed.forEach(t -> operationStrategy.get(t.getOperation()).operation(t));
        return Storage.getMap();
    }
}
