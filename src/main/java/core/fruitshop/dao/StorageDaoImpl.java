package core.fruitshop.dao;

import core.fruitshop.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void addProduct(String productName, int amount) {
        Storage.fruitsStorage.put(productName, amount);
    }

    @Override
    public void setAmount(String productName, int amount) {
        Storage.fruitsStorage.put(productName, amount);
    }

    @Override
    public int getAmount(String productName) {
        return Storage.fruitsStorage.get(productName);
    }

    public boolean contains(String productName) {
        return Storage.fruitsStorage.containsKey(productName);
    }

    @Override
    public Map<String, Integer> dumpData() {
        return Storage.fruitsStorage;
    }
}
