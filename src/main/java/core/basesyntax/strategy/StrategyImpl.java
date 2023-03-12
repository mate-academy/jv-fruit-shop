package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.operation.Operation;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private final Map<Transaction.Operation, Operation> map;

    public StrategyImpl(Map<Transaction.Operation, Operation> map) {
        this.map = map;
    }

    @Override
    public Operation getByOperation(Transaction.Operation operation) {
        return map.get(operation);
    }
}

