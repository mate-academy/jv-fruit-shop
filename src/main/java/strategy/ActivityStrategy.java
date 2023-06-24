package strategy;

import model.ActivityType;

public interface ActivityStrategy {
    ActivityHandler getHandler(ActivityType activity);
}
