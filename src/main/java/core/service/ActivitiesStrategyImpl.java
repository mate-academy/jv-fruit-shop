package core.service;

import core.activities.ActivitiesHandler;
import java.util.Map;
import java.util.Optional;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    private final Map<String, ActivitiesHandler> activitiesMap;

    public ActivitiesStrategyImpl(Map<String, ActivitiesHandler> activitiesMap) {
        this.activitiesMap = activitiesMap;
    }

    @Override
    public ActivitiesHandler get(String typeOfActivity) {
        Optional<ActivitiesHandler> activitiesHandler =
                Optional.of(activitiesMap.get(typeOfActivity));
        return activitiesHandler.orElseThrow(RuntimeException::new);
    }
}
