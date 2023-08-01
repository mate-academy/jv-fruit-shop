package core.basesyntax.service.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ActivitiesService;
import java.util.Map;

public class ActivityStrategyImpl implements ActivityStrategy {
    private Map<Fruit.Operation, ActivitiesService> activitiesServiceMap;

    public ActivityStrategyImpl(Map<Fruit.Operation, ActivitiesService> activitiesServiceMap) {
        this.activitiesServiceMap = activitiesServiceMap;
    }

    public ActivitiesService getQuantityModifier(Fruit.Operation operation) {
        return activitiesServiceMap.get(operation);

    }
}
