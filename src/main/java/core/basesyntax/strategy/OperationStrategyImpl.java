package core.basesyntax.strategy;

import core.basesyntax.dto.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> strategies;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> strategies) {
        this.strategies = strategies;
    }

    @Override
    public OperationHandler findHandler(FruitTransaction.Operation operation) {
        return strategies.get(operation);
    }
}
