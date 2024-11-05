package core.basesyntax.db;

import core.basesyntax.storage.Storage;
import java.util.Set;

public class StockDaoStorageImpl implements StockDao {

    @Override
    public void set(String product, Integer amount) {
        Storage.stock.put(product, amount);
    }

    @Override
    public Integer get(String product) {
        return Storage.stock.get(product);
    }

    @Override
    public void decrease(String product, Integer amount) {
        if (contain(product)) {
            Storage.stock.put(product, get(product) - amount);
        } else if (get(product) - amount < 0) {
            throw new RuntimeException(
                    "the quantity being subtracted is greater than the stock value");
        } else {
            throw new RuntimeException("There was no such product before");
        }
    }

    @Override
    public void increase(String product, Integer amount) {
        if (!contain(product)) {
            throw new RuntimeException("There was no such product before");
        } else if (get(product) + amount < 0) {
            throw new RuntimeException("amount out limit");
        } else {
            Storage.stock.put(product, get(product) + amount);
        }
    }

    @Override
    public boolean contain(String product) {
        return Storage.stock.containsKey(product);
    }

    @Override
    public Set<String> getProductsList() {
        return Storage.stock.keySet();
    }
}
