package core.basesyntax.parsers.impl;

import core.basesyntax.model.ActivityType;
import core.basesyntax.parsers.ActivityTypeParser;

import java.util.HashMap;
import java.util.Map;

public class ActivityTypeParserImpl implements ActivityTypeParser {
    private Map<Character, ActivityType> operationMap;

    public ActivityTypeParserImpl() {
        operationMap = new HashMap();
        operationMap.put('b', ActivityType.BALANCE);
        operationMap.put('p', ActivityType.PURCHASE);
        operationMap.put('r', ActivityType.RETURN);
        operationMap.put('s', ActivityType.SUPPLY);
    }

    @Override
    public ActivityType getActivityType(char operationIdentifier) {
        return operationMap.get(operationIdentifier);
    }
}
