package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.service.Product;
import java.util.Map;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao {
    @Override
    public void add(Product product, int amount) {
        Storage.getProducts().put(product, amount);
    }

    @Override
    public int get(Product product) {
        Optional<Integer> optional = Optional.ofNullable(Storage.getProducts().get(product));
        return optional.orElse(0);
    }

    @Override
    public Map<Product, Integer> getMap() {
        return Storage.getProducts();
    }
}
