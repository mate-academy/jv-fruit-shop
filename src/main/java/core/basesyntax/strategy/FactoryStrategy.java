package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class FactoryStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> strategyType;

    public FactoryStrategy(Map<FruitTransaction.Operation, OperationHandler> strategyType) {
        this.strategyType = strategyType;
    }

    public OperationHandler getFruitService(FruitTransaction.Operation operation) {
        return strategyType.get(operation);
    }
}
