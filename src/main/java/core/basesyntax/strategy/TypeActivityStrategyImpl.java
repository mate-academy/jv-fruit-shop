package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.amount.ActivityHandler;
import java.util.Map;

public class TypeActivityStrategyImpl implements TypeActivityStrategy {
    private final Map<Operation, ActivityHandler> strategyMap;

    public TypeActivityStrategyImpl(Map<Operation, ActivityHandler> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public ActivityHandler get(Operation operation) {
        return strategyMap.get(operation);
    }
}
