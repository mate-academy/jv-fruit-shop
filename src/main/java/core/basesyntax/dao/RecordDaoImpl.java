package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Product;
import java.util.List;
import java.util.Map;

public class RecordDaoImpl implements RecordDao {
    private final Map<String, Product> storage = Storage.getInstance().getStorage();

    @Override
    public void put(Product product) {
        storage.put(product.getName(), product);
    }

    @Override
    public Product get(Product product) {
        return storage.get(product.getName());
    }

    @Override
    public List<Product> getAllFromDB() {
        return List.copyOf(storage.values());
    }

    @Override
    public boolean remove(Product product) {
        return storage.remove(product.getName(), product);
    }

    @Override
    public void clear() {
        storage.clear();
    }
}
