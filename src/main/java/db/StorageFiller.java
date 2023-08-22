package db;

import java.util.List;
import model.Activity;
import strategy.ActivityTypeStrategy;

public interface StorageFiller {
    void fullfillStorage(Storage storage, List<Activity> activityList, ActivityTypeStrategy activityTypeStrategy);
}
