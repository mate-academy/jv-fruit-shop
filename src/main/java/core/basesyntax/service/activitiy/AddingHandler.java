package core.basesyntax.service.activitiy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoCsvImpl;
import core.basesyntax.model.FruitCrate;

public class AddingHandler implements ActivityHandler {
    private static final StorageDao storageDao = new StorageDaoCsvImpl();

    @Override
    public FruitCrate updateFruitCrate(String fruitName, int quantity) {
        FruitCrate storedCrate = storageDao.get(fruitName);
        if (storedCrate == null) {
            return storageDao.add(new FruitCrate(fruitName, quantity));
        }
        storageDao.remove(fruitName);
        return storageDao.add(new FruitCrate(fruitName, storedCrate.getQuantity() + quantity));
    }
}
