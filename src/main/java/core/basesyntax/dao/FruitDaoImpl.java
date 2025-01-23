package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.models.Product;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public List<Product> getAll() {
        return Storage.PRODUCT_STORAGE;
    }
}
