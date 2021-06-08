package core.basesyntax.dao;

import core.basesyntax.service.Product;
import java.util.Map;

public interface ProductDao {
    void add(Product product, int amount);

    int get(Product product);

    Map<Product, Integer> getAll();
}
