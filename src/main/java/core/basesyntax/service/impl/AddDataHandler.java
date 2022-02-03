package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.DataHandler;

public class AddDataHandler implements DataHandler {

    @Override
    public void processData(StorageDao storageDao, Fruit fruit, int quantity) {
        storageDao.addQuantityByFruit(fruit,quantity);
    }
}
