package core.basesyntax.service.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.ItemActivities;

public class ActivitiesHandlerOfBalance implements ActivitiesHandler {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void update(ItemActivities itemActivities) {
        storageDao.add(new Fruit(itemActivities.getItem(), itemActivities.getQuantity()));
    }
}
