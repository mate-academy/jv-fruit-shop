package core.basesyntax.service.impl;

import core.basesyntax.model.FruitActivity;
import core.basesyntax.service.ActivitiesProcessor;
import core.basesyntax.service.ActivityStrategy;

import java.util.List;

public class ActivitiesProcessorImpl implements ActivitiesProcessor {
    private final ActivityStrategy activityStrategyImpl;

    public ActivitiesProcessorImpl(ActivityStrategyImpl activityStrategyImpl) {
        this.activityStrategyImpl = activityStrategyImpl;
    }

    @Override
    public void processActivities(List<FruitActivity> activities) {
        for (FruitActivity fruitActivity : activities) {
            FruitActivity.Type activityType = fruitActivity.getActivityType();
            activityStrategyImpl.get(activityType).processActivity(fruitActivity);
        }
    }
}
