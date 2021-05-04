package core.basesyntax.dao;

import core.basesyntax.service.Product;
import java.util.Map;

public interface ProductDao {
    void add(Product product, int value);

    int get(Product product);

    Map<Product, Integer> getAll();
}
