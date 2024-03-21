package core.basesyntax.strategy;

import core.basesyntax.dto.Transaction;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Transaction.Operation, OperationHandler> strategies;

    public OperationStrategyImpl(Map<Transaction.Operation, OperationHandler> strategies) {
        this.strategies = strategies;
    }

    @Override
    public OperationHandler findHandler(Transaction.Operation operation) {
        return strategies.get(operation);
    }
}
