package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.ShopService;
import java.util.Map;

public class FruitShopService implements ShopService {
    private final StorageDao storageDao;

    public FruitShopService(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public Map<String, Integer> getBalance() {
        return storageDao.getAll();
    }
}
