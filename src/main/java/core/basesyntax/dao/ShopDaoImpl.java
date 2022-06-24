package core.basesyntax.dao;

import java.util.Map;

public class ShopDaoImpl implements ShopDao {
    private final Map<String, Integer> storage;

    public ShopDaoImpl(Map<String, Integer> storage) {
        this.storage = storage;
    }

    @Override
    public Integer get(String fruit) {
        return storage.get(fruit);
    }

    @Override
    public Map<String, Integer> getAll() {
        return storage;
    }

    @Override
    public void update(String fruit, int newAmount) {
        storage.put(fruit, newAmount);
    }
}
