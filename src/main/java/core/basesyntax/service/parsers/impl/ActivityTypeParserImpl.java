package core.basesyntax.service.parsers.impl;

import core.basesyntax.model.ActivityType;
import core.basesyntax.service.parsers.ActivityTypeParser;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ActivityTypeParserImpl implements ActivityTypeParser {
    private Map<Character, ActivityType> activityMap;

    public ActivityTypeParserImpl() {
        activityMap = new HashMap();
        Arrays.stream(ActivityType.values())
                .forEach(a -> activityMap
                        .put(a.getActivityIdentifier(), a));
    }

    @Override
    public ActivityType parse(char operationIdentifier) {
        return activityMap.get(operationIdentifier);
    }
}
