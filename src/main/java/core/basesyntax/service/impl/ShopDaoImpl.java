package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ShopDao;
import java.util.Map;
import java.util.Set;

public class ShopDaoImpl implements ShopDao {
    private final Storage storage;

    public ShopDaoImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public Map.Entry<String, Integer> get(String fruit) {
        Set<Map.Entry<String, Integer>> fruits = storage.getShopStorage().entrySet();
        for (Map.Entry<String, Integer> entry : fruits) {
            if (entry.getKey().equals(fruit)) {
                return entry;
            }
        }
        throw new RuntimeException("There is no such fruit in the Storage");
    }

    @Override
    public Map<String, Integer> getAll() {
        return storage.getShopStorage();
    }

    @Override
    public void update(String fruit, int newAmount) {
        Map<String, Integer> shopStorage = storage.getShopStorage();
        if (shopStorage.containsKey(fruit)) {
            shopStorage.put(fruit, newAmount);
        } else {
            throw new RuntimeException("Unknown fruit: " + fruit);
        }
    }
}
