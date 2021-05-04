package core.basesyntax.dao;

import core.basesyntax.database.Storage;
import core.basesyntax.service.Product;

import java.util.Map;

public class ProductDaoImpl implements ProductDao{
    @Override
    public void add(Product product, int value) {
        Storage.getProducts().put(product, value);
    }

    @Override
    public int get(Product product) {
        return Storage.getProducts().getOrDefault(product, 0);
    }

    @Override
    public Map<Product, Integer> getAll() {
        return Storage.getProducts();
    }
}
