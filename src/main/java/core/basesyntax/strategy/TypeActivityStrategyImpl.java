package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.amount.ActivityHandler;
import java.util.Map;

public class TypeActivityStrategyImpl implements TypeActivityStrategy {
    private Map<FruitTransaction.Operation, ActivityHandler> strategyMap;

    public TypeActivityStrategyImpl(Map<FruitTransaction.Operation, ActivityHandler> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public ActivityHandler get(FruitTransaction.Operation operation) {
        return strategyMap.get(operation);
    }
}
