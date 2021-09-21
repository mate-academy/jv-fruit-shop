package core.basesyntax.service;

import core.basesyntax.model.ActivitiesType;
import core.basesyntax.service.activityhandler.ActivityTypeHandler;
import core.basesyntax.service.validators.InputValidator;
import java.util.List;

public class ActivitiesServiceImpl implements ActivitiesService {
    private static final int HEAD_STRING = 0;
    private static final int ACTIVITY_TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String REGEX = ",";
    private InputValidator validator;

    public ActivitiesServiceImpl(InputValidator validator) {
        this.validator = validator;
    }

    @Override
    public void processingActivities(ActivityTypeStrategy activityTypeStrategy,
                                     List<String> activities) {
        validator.validate(activities);
        activities.remove(HEAD_STRING);
        for (String activity : activities) {
            String[] activitySplit = activity.split(REGEX);
            ActivityTypeHandler activityHandler = activityTypeStrategy
                    .get(ActivitiesType
                            .valueOf(activitySplit[ACTIVITY_TYPE_INDEX]));
            activityHandler.processActivity(activitySplit[FRUIT_INDEX],
                    Integer.parseInt(activitySplit[AMOUNT_INDEX]));
        }
    }
}
