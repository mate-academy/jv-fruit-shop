package core.basesyntax.parsers;

import core.basesyntax.model.ActivityType;

public interface ActivityTypeParser {
    ActivityType getActivityType(char activityIdentifier);
}
