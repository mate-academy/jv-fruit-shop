package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction.OperationType;
import java.util.HashMap;
import java.util.Map;

public class HandlerStrategy {
    private static Map<OperationType, OperationHandler> strategyMap;

    public HandlerStrategy(Map<OperationType, OperationHandler> strategyMap) {
        HandlerStrategy.strategyMap = new HashMap<>();
    }

    public static Map<OperationType, OperationHandler> getStrategyMap() {
        return strategyMap;
    }

    public OperationHandler getHandlerByOperationType(OperationType operationType) {
        return strategyMap.get(operationType);
    }
}
