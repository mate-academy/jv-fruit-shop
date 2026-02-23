package service;

import java.util.List;
import model.Activity;

public class ActivityService {
    private final StrategyProvider provider;

    public ActivityService(StrategyProvider provider) {
        this.provider = provider;
    }

    public void process(List<Activity> activities) {
        for (Activity activity : activities) {
            ActivityStrategy strategy =
                    provider.getStrategy(activity.getType());

            strategy.doActivity(
                    activity.getFruitName(),
                    activity.getQuantity()
            );
        }
    }
}
