package core.basesyntax.service.activitiy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoCsvImpl;
import core.basesyntax.model.FruitCrate;

public class RemovingHandler implements ActivityHandler {
    private static final StorageDao storageDao = new StorageDaoCsvImpl();

    @Override
    public FruitCrate updateFruitCrate(String fruitName, int quantity) {
        FruitCrate storedCrate = storageDao.get(fruitName);
        if (storedCrate == null
                || storedCrate.getQuantity() - quantity < 0) {
            throw new RuntimeException("Not enough " + fruitName + " to sell");
        }
        return storageDao.update(fruitName, storedCrate.getQuantity() - quantity);
    }
}
