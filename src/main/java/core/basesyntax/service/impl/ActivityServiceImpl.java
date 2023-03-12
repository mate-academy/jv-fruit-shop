package core.basesyntax.service.impl;

import core.basesyntax.model.Activity;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ActivityService;
import java.util.List;
import java.util.stream.Collectors;

public class ActivityServiceImpl implements ActivityService {
    private static final String SEPARATOR = ",";
    private static final int CODE_INDEX = 0;
    private static final int ITEM_INDEX = 1;
    private static final int LEGEND_LINE = 1;
    private static final int QUANTITY_INDEX = 2;
    private final Activity.Builder activityBuilder = new Activity.Builder();

    @Override
    public List<Activity> getActivitiesFromInput(List<String> dataFromFile) {
        return dataFromFile.stream()
                .skip(LEGEND_LINE)
                .map(this::get)
                .collect(Collectors.toList());
    }

    private Activity get(String data) {
        String[] activityUnits = data.split(SEPARATOR);
        activityBuilder.setOperation(Operation.getByCode(activityUnits[CODE_INDEX]));
        activityBuilder.setItem(activityUnits[ITEM_INDEX]);
        activityBuilder.setQuantity(Integer.parseInt(activityUnits[QUANTITY_INDEX]));
        return activityBuilder.build();
    }
}
