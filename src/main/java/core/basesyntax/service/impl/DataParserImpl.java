package core.basesyntax.service.impl;

import core.basesyntax.model.FruitActivity;
import core.basesyntax.service.DataParser;
import java.util.ArrayList;
import java.util.List;

public class DataParserImpl implements DataParser {
    private static final int ACTIVITY_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitActivity> processFile(List<String> lines) {
        lines.remove(0);
        List<FruitActivity> activities = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            activities.add(makeActivityFromLine(lines.get(i)));
        }
        return activities;
    }

    public static FruitActivity makeActivityFromLine(String activityLine) {
        String[] activitySplit = activityLine.split(SEPARATOR);
        FruitActivity.Type activityType =
                FruitActivity.Type.getType(activitySplit[ACTIVITY_TYPE_INDEX]);
        String fruitName = activitySplit[FRUIT_NAME_INDEX];
        Integer quantity = Integer.parseInt(activitySplit[QUANTITY_INDEX]);
        return new FruitActivity(activityType, fruitName, quantity);
    }
}
