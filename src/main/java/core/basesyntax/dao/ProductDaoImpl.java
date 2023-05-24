package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Product;

public class ProductDaoImpl implements ProductDao<Product, Integer> {
    @Override
    public Integer put(Product product, Integer value) {
        return Storage.storage.put(product, value);
    }

    @Override
    public Integer get(Product product) {
        return Storage.storage.get(product);
    }

    @Override
    public void clear() {
        Storage.storage.clear();
    }
}
