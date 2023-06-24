package core.basesyntax.db.impl;

import core.basesyntax.db.ProductStorage;
import core.basesyntax.model.Product;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ProductStorageImpl implements ProductStorage {
    private final HashMap<String, Integer> storage = new HashMap<>();

    @Override
    public void put(Product product) {
        storage.put(product.getName(), product.getQuantity());
    }

    @Override
    public Product getByName(String name) {
        return new Product(name, storage.getOrDefault(name, 0));
    }

    @Override
    public List<Product> getAll() {
        return storage.entrySet()
                .stream()
                .map(entry -> new Product(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
