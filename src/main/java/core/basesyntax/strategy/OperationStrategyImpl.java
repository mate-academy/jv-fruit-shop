package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> strategyMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return strategyMap.get(operation);
    }
}
