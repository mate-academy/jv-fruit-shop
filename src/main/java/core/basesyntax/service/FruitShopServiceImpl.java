package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    @Override
    public void add(String fruit, int quantity) {
        Storage.storage.put(fruit, quantity);
    }

    @Override
    public Integer getAmount(String fruit) {
        return Storage.storage.get(fruit);
    }

    @Override
    public Map<String, Integer> getStorage() {
        return Storage.storage;
    }
}
