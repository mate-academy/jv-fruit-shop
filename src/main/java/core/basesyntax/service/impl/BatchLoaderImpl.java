package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitCrate;
import core.basesyntax.service.BatchLoader;
import core.basesyntax.service.activitiy.ActivityType;
import core.basesyntax.strategy.ActivitiesStrategy;
import java.util.ArrayList;
import java.util.List;

public class BatchLoaderImpl implements BatchLoader {
    private final StorageDao storageDao;
    private final ActivitiesStrategy activitiesStrategy;

    public BatchLoaderImpl(StorageDao storageDao, ActivitiesStrategy activitiesStrategy) {
        this.storageDao = storageDao;
        this.activitiesStrategy = activitiesStrategy;
    }

    @Override
    public List<FruitCrate> loadBatch(List<String> fileData) {
        List<String> activityData = new ArrayList<>(fileData);
        activityData.remove(0);
        activityData.stream()
                .map(s -> activitiesStrategy.get(ActivityType.valueOf(s.split(",")[0]))
                        .getFruit(s.split(",")[1], Integer.parseInt(s.split(",")[2])))
                .forEach(storageDao::add);
        return storageDao.getAll();
    }
}
