package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProductDaoImp implements ProductDao {
    @Override
    public void add(String product, Integer quantity) {
        Storage.product.put(product, quantity);
    }

    @Override
    public Optional<Integer> get(String product) {
        return Optional.ofNullable(Storage.product.get(product));
    }

    @Override
    public Map<String, Integer> getAll() {
        return new HashMap<>(Storage.product);
    }
}
