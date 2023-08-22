package db;

import java.util.List;
import model.Activity;
import strategy.ActivityTypeStrategy;

public class StorageFillerImpl implements StorageFiller {
    @Override
    public void fullfillStorage(Storage storage, List<Activity> activityList, ActivityTypeStrategy activityTypeStrategy) {
        for (Activity activity : activityList) {
            storage.getFruitBox().put(activity.getFruit(), activityTypeStrategy
                    .get(activity.getType())
                    .getNewQuantity(
                            storage.getFruitBox()
                            .get(activity.getFruit()) != null ? storage.getFruitBox()
                                    .get(activity.getFruit()) : 0,activity.getQuantity())
            );
        }
    }
}
