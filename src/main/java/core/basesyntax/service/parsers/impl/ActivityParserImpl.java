package core.basesyntax.service.parsers.impl;

import core.basesyntax.model.Activity;
import core.basesyntax.service.parsers.ActivityParser;

public class ActivityParserImpl implements ActivityParser {
    public static final String CSV_SEPARATOR = ",";
    public static final int VALUES_QUANTITY = 3;

    @Override
    public Activity parse(String line) {
        String[] values = line.split(CSV_SEPARATOR);
        if (values.length != VALUES_QUANTITY) {
            throw new RuntimeException("Wrong quantity of values in line: " + line);
        }
        Activity activity = new Activity.Builder()
                .setActivityType(new ActivityTypeParserImpl().parse(values[0].charAt(0)))
                .setFruit(new FruitParserImpl().parse(values[1]))
                .setQuantity(Integer.valueOf(values[2]))
                .build();
        return activity;
    }
}
