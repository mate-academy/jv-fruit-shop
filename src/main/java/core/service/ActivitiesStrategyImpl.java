package core.service;

import core.model.Operations;
import core.strategy.AmountHandler;
import java.util.Map;
import java.util.Optional;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    private final Map<Operations, AmountHandler> activitiesMap;

    public ActivitiesStrategyImpl(Map<Operations, AmountHandler> activitiesMap) {
        this.activitiesMap = activitiesMap;
    }

    @Override
    public AmountHandler get(Operations typeOfActivity) {
        Optional<AmountHandler> activitiesHandler =
                Optional.of(activitiesMap.get(typeOfActivity));
        return activitiesHandler.orElseThrow(RuntimeException::new);
    }
}
