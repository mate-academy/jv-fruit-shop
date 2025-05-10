package core.basesyntax.dao;

import core.basesyntax.model.Product;
import java.util.List;

public interface RecordDao {
    void put(Product product);

    Product get(Product product);

    List<Product> getAll();

    boolean remove(Product product);
}
