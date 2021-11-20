package core.basesyntax.service.impl;

import core.basesyntax.strategy.Activity;
import core.basesyntax.service.ActivityParser;

public class ActivityParserImpl implements ActivityParser {
    public static final String CSV_SEPARATOR = ",";

    @Override
    public Activity parse(String line) {
        String[] values = line.split(CSV_SEPARATOR);
        Activity activity =  new ActivityServiceImpl().getActivity(values[0].charAt(0));
        activity.setQuantity(Integer.valueOf(values[2]));
        return activity;
    }
}
