package core.basesyntax.service;

import core.basesyntax.model.Activity;
import core.basesyntax.model.TypeActivity;
import core.basesyntax.service.strategy.data.CharToActivity;
import java.util.Map;

public class ActivityParseImpl implements ActivityParse {
    private static final int INDEX_CHAR_ACTIVITY = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_COUNT = 2;
    private static final Map<String, TypeActivity> CHAR_TO_ACTIVITY = CharToActivity.map;

    @Override
    public Activity toActivity(String string) {
        String[] array = string.split(",");
        return new Activity(
                CHAR_TO_ACTIVITY.get(array[INDEX_CHAR_ACTIVITY]),
                array[INDEX_FRUIT],
                Integer.parseInt(array[INDEX_COUNT])
        );
    }
}
