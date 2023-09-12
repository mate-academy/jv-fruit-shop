package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(String product, Integer value) {
        if (value < 0) {
            throw new RuntimeException("Amount of products '" + product + "' can`t be less than 0");
        }
        Storage.STOCK.put(product, value);
    }

    @Override
    public void substractAmount(String product, Integer amountToDelete) {
        Integer value = Storage.STOCK.get(product);
        if (value < amountToDelete) {
            throw new RuntimeException("Amount of products is not enough. Available: "
                    + value + " You want to buy: " + amountToDelete);
        }
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
