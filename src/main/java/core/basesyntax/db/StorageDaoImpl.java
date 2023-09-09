package core.basesyntax.db;

import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(String product, Integer value) {
        if (value >= 0) {
            Storage.STOCK.put(product, value);
            return;
        }
        throw new RuntimeException("Amount of products '" + product + "' can`t be less than 0");
    }

    @Override
    public void substractAmount(String product, Integer amountToDelete) {
        Integer value = Storage.STOCK.get(product);
        value -= amountToDelete;
        add(product, value);
    }

    @Override
    public void addAmount(String product, Integer amountToAdd) {
        Integer value = Storage.STOCK.get(product);
        value += amountToAdd;
        add(product, value);
    }

    @Override
    public Map<String, Integer> getStock() {
        return Storage.STOCK;
    }
}
