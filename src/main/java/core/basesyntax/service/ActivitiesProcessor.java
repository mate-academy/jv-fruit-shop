package core.basesyntax.service;

import core.basesyntax.model.FruitActivity;
import java.util.List;

public interface ActivitiesProcessor {
    void processActivities(List<FruitActivity> activities);
}
