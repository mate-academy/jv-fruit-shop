package core.basesyntax.service.parsers.impl;

import core.basesyntax.model.Activity;
import core.basesyntax.service.Validator;
import core.basesyntax.service.impl.ValidatorImpl;
import core.basesyntax.service.parsers.ActivityParser;

public class ActivityParserImpl implements ActivityParser {
    private static final String CSV_SEPARATOR = ",";
    private Validator validator;

    public ActivityParserImpl() {
        validator = new ValidatorImpl();
    }

    @Override
    public Activity parse(String line) {
        String[] values = line.split(CSV_SEPARATOR);
        validator.validate(values);
        Activity activity = new Activity.Builder()
                .setActivityType(new ActivityTypeParserImpl().parse(values[0].charAt(0)))
                .setFruit(new FruitParserImpl().parse(values[1]))
                .setQuantity(Integer.valueOf(values[2]))
                .build();
        return activity;
    }
}
