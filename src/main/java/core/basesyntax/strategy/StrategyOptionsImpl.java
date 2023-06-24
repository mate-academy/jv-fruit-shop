package core.basesyntax.strategy;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class StrategyOptionsImpl implements StrategyOptions {
    private final Map<FruitTransaction.Operation, OperationHandler> strategy;

    public StrategyOptionsImpl(Map<FruitTransaction.Operation, OperationHandler> strategy) {
        this.strategy = strategy;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation type) {
        return strategy.get(type);
    }
}
