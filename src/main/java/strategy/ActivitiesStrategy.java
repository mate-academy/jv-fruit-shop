package strategy;

import strategy.activities.ActivitiesHandler;

public interface ActivitiesStrategy {
    ActivitiesHandler get(String firstChar);
}
