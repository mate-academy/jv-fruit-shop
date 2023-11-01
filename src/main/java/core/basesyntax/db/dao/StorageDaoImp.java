package core.basesyntax.db.dao;

import java.util.HashMap;
import java.util.Map;

public class StorageDaoImp implements StorageDao {
    private final Map<String, Integer> storage;

    public StorageDaoImp(Map<String, Integer> storage) {
        this.storage = storage;
    }

    @Override
    public Integer getQuantityGoods(String goods) {
        return storage.get(goods);
    }

    @Override
    public void setQuantityGoods(String goods, Integer newQuantity) {
        storage.put(goods, newQuantity);
    }

    @Override
    public Map<String, Integer> getStock() {
        return new HashMap<>(storage);
    }
}
