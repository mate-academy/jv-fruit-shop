package core.basesyntax.startegy;

import core.basesyntax.dao.StorageDao;

public interface ActivitiesService {
    void getActivity(String name, int quantity, StorageDao storageDao);
}
