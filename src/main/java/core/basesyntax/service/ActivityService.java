package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public interface ActivityService {
    Map<String, Integer> processActivities(ActivityTypeStrategy activityTypeStrategy,
                                              List<String> activities);
}
