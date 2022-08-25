package core.basesyntax.service;

import core.basesyntax.model.Activity;
import core.basesyntax.service.maps.DecodeShortActivity;

public class ActivityParseImpl implements ActivityParse {
    private static final int INDEX_CHAR_ACTIVITY = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_COUNT = 2;
    private final DecodeStrategy decodeStrategy;

    public ActivityParseImpl() {
        decodeStrategy = new DecodeStrategyImpl(DecodeShortActivity.map);
    }

    @Override
    public Activity toActivity(String string) {
        String[] array = string.split(",");
        return new Activity(
                decodeStrategy.get(array[INDEX_CHAR_ACTIVITY]),
                array[INDEX_FRUIT],
                Integer.parseInt(array[INDEX_COUNT])
        );
    }
}
