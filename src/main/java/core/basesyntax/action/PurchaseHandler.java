package core.basesyntax.action;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;

public class PurchaseHandler implements ActionHandler {
    private final StorageDao storageDao;

    public PurchaseHandler() {
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public int performAction(String fruitName, int amount) {
        return storageDao.get(fruitName) - amount;
    }
}
