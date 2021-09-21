package Service;

import Service.Activities.Activities;
import Service.Activities.TypeOfActivities;

import java.util.Map;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    private Map<TypeOfActivities, Activities> activitiesMap;

    public ActivitiesStrategyImpl(Map<TypeOfActivities, Activities> activitiesMap) {
        this.activitiesMap = activitiesMap;
    }

    @Override
    public Activities get(TypeOfActivities type) {
        return activitiesMap.get(type);
    }
}
