package core.basesyntax.dao;

import core.basesyntax.model.Product;
import core.basesyntax.storage.Storage;
import java.util.Map;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao {
    @Override
    public void add(Product fruit, int amount) {
        Storage.productStorage.put(fruit, amount);
    }

    @Override
    public Optional<Integer> get(Product key) {
        return Optional.ofNullable(Storage.productStorage.get(key));
    }

    @Override
    public Map<Product, Integer> getAll() {
        return Storage.productStorage;
    }
}
