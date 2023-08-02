package core.basesyntax.service;

import core.basesyntax.model.Activity;
import java.util.List;

public interface ActivitiesProcessor {
    void processActivities(List<Activity> listOfActivities);
}
