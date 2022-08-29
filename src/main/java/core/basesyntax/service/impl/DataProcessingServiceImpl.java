package core.basesyntax.service.impl;

import java.util.List;
import java.util.Map;
import core.basesyntax.db.StorageFruits;
import core.basesyntax.model.Activity;
import core.basesyntax.service.DataProcessingService;

public class DataProcessingServiceImpl implements DataProcessingService {
    private Map<String, Integer> result;

    @Override
    public Map<String, Integer> processTheData(List<Activity> activities) {
        for (Activity activity : activities) {
            activity.getStrategy().makeOperation(activity.getFruit(), activity.getValue());
        }
        return StorageFruits.fruits;
    }
}
