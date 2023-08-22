package strategy;

import model.ActivityType;

public interface ActivityTypeStrategy {
    ActivityTypeHandler get(ActivityType type);
}
