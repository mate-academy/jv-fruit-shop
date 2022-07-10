package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.quantity.CounterHandler;
import java.util.Map;

public class CounterStrategyImpl implements CounterStrategy {
    private final Map<FruitTransaction.Operation, CounterHandler> counterHandlerMap;

    public CounterStrategyImpl(Map<FruitTransaction.Operation, CounterHandler> counterHandlerMap) {
        this.counterHandlerMap = counterHandlerMap;
    }

    @Override
    public CounterHandler get(FruitTransaction.Operation operation) {
        return counterHandlerMap.get(operation);
    }
}
