package core.basesyntax.service.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Item;
import core.basesyntax.model.ItemOperation;

public class OperationHandlerOfSupply implements OperationHandler {
    private final StorageDao storageDao;

    public OperationHandlerOfSupply(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void update(ItemOperation itemOperation) {
        Item item = storageDao.get(itemOperation.getItem());
        item.setQuantity(item.getQuantity() + itemOperation.getQuantity());
    }
}
