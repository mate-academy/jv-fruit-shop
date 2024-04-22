package core.basesyntax.strategy;

import core.basesyntax.Main;
import core.basesyntax.operation.StoreOperation;
import core.basesyntax.service.QuantityCounter;
import java.util.Map;

public class QuantityCounterStrategyImpl implements QuantityCounterStrategy {
    private Map<StoreOperation.Operation, QuantityCounter> quantityCounterMap = Main.get();

    @Override
    public QuantityCounter get(StoreOperation operation) {
        return quantityCounterMap.get(operation.getOperation());
    }
}
