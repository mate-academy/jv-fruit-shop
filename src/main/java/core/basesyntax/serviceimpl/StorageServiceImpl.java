package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.StorageService;
import java.util.Map;

public class StorageServiceImpl implements StorageService {
    private final Storage storage = new Storage();

    @Override
    public int getQuantity(String key) {
        return storage.getProducts().get(key);
    }

    @Override
    public void add(String fruitName, Integer value) {
        storage.getProducts().put(fruitName, value);
    }

    @Override
    public Map<String, Integer> getAll() {
        return storage.getProducts();
    }

    @Override
    public void updateQuantity(String fruitName, Integer value) {
        if (storage.getProducts().containsKey(fruitName)) {
            storage.getProducts().put(fruitName, value);
        } else {
            add(fruitName, value);
        }
    }
}
