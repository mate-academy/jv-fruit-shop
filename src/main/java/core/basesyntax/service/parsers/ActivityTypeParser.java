package core.basesyntax.service.parsers;

import core.basesyntax.model.ActivityType;

public interface ActivityTypeParser {
    ActivityType parse(char activityIdentifier);
}
