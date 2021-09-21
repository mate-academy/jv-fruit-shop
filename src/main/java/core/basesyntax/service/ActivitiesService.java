package core.basesyntax.service;

import java.util.List;

public interface ActivitiesService {
    void processingActivities(ActivityTypeStrategy activityTypeStrategy, List<String> activities);
}
