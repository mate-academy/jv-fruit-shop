package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitCrate;
import core.basesyntax.service.BatchLoader;
import core.basesyntax.strategy.ActivitiesStrategy;
import java.util.List;
import java.util.stream.IntStream;

public class BatchLoaderImpl implements BatchLoader {
    private static final int ACTIVITY_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final StorageDao storageDao;
    private final ActivitiesStrategy activitiesStrategy;

    public BatchLoaderImpl(StorageDao storageDao, ActivitiesStrategy activitiesStrategy) {
        this.storageDao = storageDao;
        this.activitiesStrategy = activitiesStrategy;
    }

    @Override
    public List<FruitCrate> loadBatch(List<String> fileData) {
        IntStream.range(1, fileData.size())
                .mapToObj(i -> fileData.get(i).split(","))
                .forEach(line -> activitiesStrategy.get(line[ACTIVITY_TYPE_INDEX])
                        .updateFruitCrate(line[FRUIT_NAME_INDEX],
                                Integer.parseInt(line[QUANTITY_INDEX])));
        return storageDao.getAll();
    }
}
