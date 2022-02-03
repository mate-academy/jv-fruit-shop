package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;

public interface DataHandler {

    void processData(StorageDao storageDao, Fruit fruit, int quantity);
}
