package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Product;
import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao {
    @Override
    public void add(Product product) {
        Storage.products.add(product);
    }

    @Override
    public Optional<Product> get(String productName) {
        return Storage.products.stream()
                .filter(p -> p.getName().equals(productName))
                .findFirst();
    }

    @Override
    public void update(Product product) {
        Optional<Product> productFromStorage = get(product.getName());
        productFromStorage.ifPresent(value -> Storage.products.remove(value));
        add(product);
    }

    @Override
    public List<Product> getAll() {
        return Storage.products;
    }
}
