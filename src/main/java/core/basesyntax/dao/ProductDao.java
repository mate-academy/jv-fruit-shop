package core.basesyntax.dao;

import core.basesyntax.model.Product;
import java.util.Map;
import java.util.Optional;

public interface ProductDao {
    void add(Product fruit, int amount);

    Optional<Integer> get(Product key);

    Map<Product, Integer> getAll();
}
