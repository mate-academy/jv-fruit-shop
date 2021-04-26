package core.basesyntax.dao;

import core.basesyntax.model.Product;
import java.util.List;

public interface ProductDao {
    void add(Product fruit, int amount);

    List<String> getAll();
}
