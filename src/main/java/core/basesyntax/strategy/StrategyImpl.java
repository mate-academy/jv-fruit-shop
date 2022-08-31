package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.operations.OperationHandler;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private final Map<Transaction.Operation, OperationHandler> map;

    public StrategyImpl(Map<Transaction.Operation, OperationHandler> map) {
        this.map = map;
    }

    @Override
    public OperationHandler getByOperation(Transaction.Operation operation) {
        return map.get(operation);
    }
}

