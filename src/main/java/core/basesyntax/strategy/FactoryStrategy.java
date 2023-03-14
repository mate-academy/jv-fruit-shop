package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class FactoryStrategy {
    private final Map<FruitTransaction.Operation, Operation> strategies;

    public FactoryStrategy(Map<FruitTransaction.Operation, Operation> strategies) {
        this.strategies = strategies;
    }

    public Operation getOperationService(FruitTransaction.Operation operation) {
        return strategies.get(operation);
    }
}
