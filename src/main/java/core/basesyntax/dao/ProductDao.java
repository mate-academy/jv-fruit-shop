package core.basesyntax.dao;

import core.basesyntax.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductDao {
    void add(Product product);

    Optional<Product> get(String productName);

    void update(Product product);

    List<Product> getAll();
}
