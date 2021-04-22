package core.basesyntax.dao;

import core.basesyntax.service.Product;
import java.util.Map;

public interface ProductDao {
    void add(Map<Product, Integer> productsMap);

    Map<Product, Integer> get();
}
