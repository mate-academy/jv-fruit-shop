package core.basesyntax.service.parsers.impl;

import core.basesyntax.model.ActivityType;
import core.basesyntax.service.parsers.ActivityTypeParser;
import java.util.HashMap;
import java.util.Map;

public class ActivityTypeParserImpl implements ActivityTypeParser {
    private Map<Character, ActivityType> activityMap;

    public ActivityTypeParserImpl() {
        activityMap = new HashMap();
        activityMap.put('b', ActivityType.BALANCE);
        activityMap.put('p', ActivityType.PURCHASE);
        activityMap.put('r', ActivityType.RETURN);
        activityMap.put('s', ActivityType.SUPPLY);
    }

    @Override
    public ActivityType parse(char operationIdentifier) {
        return activityMap.get(operationIdentifier);
    }
}
