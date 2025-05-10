package core.basesyntax.storagedao;

import core.basesyntax.storage.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    private Map<String, Integer> storage = Storage.storage;

    @Override
    public void add(String fruit, int quantity) {
        if (quantity > 0) {
            storage.put(fruit, storage.getOrDefault(fruit, 0) + quantity);
            return;
        }
        throw new RuntimeException("Cannot add to storage because the quantity is "
                + quantity + ". Quantity must be greater than 0.");
    }

    @Override
    public void subtract(String fruit, int quantity) {
        if (storage.containsKey(fruit) && quantity <= storage.get(fruit)) {
            storage.merge(fruit, -quantity, Integer::sum);
        }
    }

    @Override
    public int getFruitQuantity(String fruit) {
        return storage.getOrDefault(fruit, 0);
    }

    @Override
    public void clear() {
        storage.clear();
    }
}
