package core.basesyntax.parsers.impl;

import core.basesyntax.model.Activity;
import core.basesyntax.parsers.ActivityParser;

public class ActivityParserImpl implements ActivityParser {
    public static final String CSV_SEPARATOR = ",";

    @Override
    public Activity parse(String line) {
        String[] values = line.split(CSV_SEPARATOR);
        Activity activity = new Activity.Builder()
                .setActivityType(new ActivityTypeParserImpl().getActivityType(values[0].charAt(0))                        )
                .setFruit(new FruitParserImpl().getFruitService(values[1], Integer.valueOf(values[2])))
                .build();
        return activity;
    }
}
