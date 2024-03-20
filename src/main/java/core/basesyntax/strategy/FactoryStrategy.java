package core.basesyntax.strategy;

import core.basesyntax.model.FruitOperation;
import java.util.Map;

public class FactoryStrategy {
    private final Map<FruitOperation, OperationHandler> strategyType;

    public FactoryStrategy(Map<FruitOperation, OperationHandler> strategyType) {
        this.strategyType = strategyType;
    }

    public OperationHandler getFruitService(FruitOperation operation) {
        return strategyType.get(operation);
    }
}
