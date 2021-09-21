package core.basesyntax.service;

import core.basesyntax.model.ActivitiesType;
import core.basesyntax.service.activityhandler.ActivityTypeHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityServiceImpl implements ActivityService {
    private static final int HEAD_STRING = 0;
    private static final int ACTIVITY_TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String REGEX = ",";

    @Override
    public Map<String, Integer> processingActivities(ActivityTypeStrategy activityTypeStrategy,
                                                     List<String> activities) {
        Map<String, Integer> storageToReport = new HashMap<>();
        activities.remove(HEAD_STRING);
        for (String activity : activities) {
            String[] activitySplit = activity.split(REGEX);
            ActivityTypeHandler activityHandler = activityTypeStrategy
                    .get(ActivitiesType
                            .valueOf(activitySplit[ACTIVITY_TYPE_INDEX]));
            try {
                activityHandler.processActivity(storageToReport, activitySplit[FRUIT_INDEX],
                        Integer.parseInt(activitySplit[AMOUNT_INDEX]));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return storageToReport;
    }
}
