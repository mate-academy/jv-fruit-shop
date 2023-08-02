package core.basesyntax.service.strategy;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private Map<Fruit.Operation, ActivityHandler> activitiesServiceMap;

    public ActivityStrategyImpl(Map<Fruit.Operation, ActivityHandler> activitiesServiceMap) {
        this.activitiesServiceMap = activitiesServiceMap;
    }

    public ActivityHandler getQuantityModifier(Fruit.Operation operation) {
        return activitiesServiceMap.get(operation);

    }
}
