package core.basesyntax.dao;

import core.basesyntax.models.Product;
import java.util.List;

public interface FruitDao {
    List<Product> getAll();
}
