package core.basesyntax.service.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.model.Item;
import core.basesyntax.model.ItemActivities;

public class ActivitiesHandlerOfReturn implements ActivitiesHandler {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void update(ItemActivities itemActivities) {
        Item item = storageDao.get(itemActivities.getItem());
        item.setQuantity(item.getQuantity() + itemActivities.getQuantity());
    }
}
