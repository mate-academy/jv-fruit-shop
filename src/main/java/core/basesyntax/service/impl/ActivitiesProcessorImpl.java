package core.basesyntax.service.impl;

import core.basesyntax.model.Activity;
import core.basesyntax.service.ActivitiesProcessor;
import java.util.List;

public class ActivitiesProcessorImpl implements ActivitiesProcessor {
    private final ActivityStrategyImpl activityStrategyImpl;

    public ActivitiesProcessorImpl(ActivityStrategyImpl activityStrategyImpl) {
        this.activityStrategyImpl = activityStrategyImpl;
    }

    @Override
    public void processActivities(List<Activity> listOfActivities) {
        for (Activity activity : listOfActivities) {
            Activity.Type activityType = activity.getActivityType();
            activityStrategyImpl.get(activityType).processActivity(activity);
        }
    }
}
