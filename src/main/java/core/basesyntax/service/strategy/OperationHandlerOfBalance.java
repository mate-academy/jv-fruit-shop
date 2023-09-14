package core.basesyntax.service.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.ItemOperation;

public class OperationHandlerOfBalance implements OperationHandler {
    private final StorageDao storageDao;

    public OperationHandlerOfBalance(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void update(ItemOperation itemOperation) {
        storageDao.add(new Fruit(itemOperation.getItem(), itemOperation.getQuantity()));
    }
}
