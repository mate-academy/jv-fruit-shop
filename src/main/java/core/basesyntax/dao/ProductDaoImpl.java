package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.service.Product;
import java.util.Map;

public class ProductDaoImpl implements ProductDao {
    @Override
    public void add(Map<Product, Integer> productsMap) {
        Storage.setProducts(productsMap);
    }

    @Override
    public Map<Product, Integer> get() {
        return Storage.getProducts();
    }
}
