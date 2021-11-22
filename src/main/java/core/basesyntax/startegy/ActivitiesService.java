package core.basesyntax.startegy;

import core.basesyntax.dao.StorageDao;

public interface ActivitiesService {
    void doActivity(String name, int quantity, StorageDao storageDao);
}
