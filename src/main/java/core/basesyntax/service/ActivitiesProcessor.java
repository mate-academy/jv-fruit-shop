package core.basesyntax.service;

import core.basesyntax.db.FruitsActivitiesBase;
import core.basesyntax.model.Activity;

public class ActivitiesProcessor {

    private final ActivityStrategy activityStrategy;

    public ActivitiesProcessor(ActivityStrategy activityStrategy) {
        this.activityStrategy = activityStrategy;
    }

    public void processActivities() {

        for (Activity activity : FruitsActivitiesBase.listOfOperations) {
            Activity.Type activityType = activity.getActivityType();
            activityStrategy.get(activityType).processActivity(activity);
        }
    }
}
