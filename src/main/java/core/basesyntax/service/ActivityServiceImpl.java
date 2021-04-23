package core.basesyntax.service;

import core.basesyntax.model.Activity;

import java.util.List;

public class ActivityServiceImpl implements ActivityService {
    private final ActivityStrategy activityStrategy;

    public ActivityServiceImpl(ActivityStrategy activityStrategy) {
        this.activityStrategy = activityStrategy;
    }
    @Override
    public void analyze(List<Activity> activities) {
        activities.forEach(activity ->
                activityStrategy.get(activity.getType()).changeBalance(activity.getFruit()));
    }
}
