package core.basesyntax.service;

import core.basesyntax.model.Activity;
import java.util.List;

public interface ActivityService {
    List<Activity> getActivitiesFromInput(List<String> dataFromFile);
}
