package core.basesyntax.db;

import core.basesyntax.model.Product;
import java.util.List;

public interface ProductStorage {
    void put(Product product);

    Product getByName(String name);

    List<Product> getAll();
}
