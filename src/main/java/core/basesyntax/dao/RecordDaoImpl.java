package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Product;
import java.util.List;
import java.util.Map;

public class RecordDaoImpl implements RecordDao {
    private static RecordDao instance;
    private final Map<String, Product> storage = Storage.getInstance().getStorage();

    private RecordDaoImpl() {
    }

    public static RecordDao getInstance() {
        if (instance == null) {
            instance = new RecordDaoImpl();
        }
        return instance;
    }

    @Override
    public void put(Product product) {
        storage.put(product.getName(), product);
    }

    @Override
    public Product get(Product product) {
        return storage.get(product.getName());
    }

    @Override
    public List<Product> getAll() {
        return List.copyOf(storage.values());
    }

    @Override
    public boolean remove(Product product) {
        return storage.remove(product.getName(), product);
    }
}
