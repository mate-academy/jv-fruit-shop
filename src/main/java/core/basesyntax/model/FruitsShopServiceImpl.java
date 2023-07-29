package core.basesyntax.model;

import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitsShopServiceImpl implements FruitShopService {
    private final OperationStrategy operationStrategy;

    public FruitsShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> parsed) {
        if (parsed == null) {
            throw new RuntimeException("Value can't be null");
        }
        parsed.forEach(t -> operationStrategy.get(t.getOperation()).operate(t));
    }
}
