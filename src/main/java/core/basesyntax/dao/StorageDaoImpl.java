package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    private Storage storage = new Storage();

    @Override
    public void add(String name, Integer quantity) {
        storage.fruits.put(name, quantity);
    }

    @Override
    public void update(String name, Integer quantity) {
        storage.fruits.put(name, quantity);
    }

    @Override
    public Integer get(String name) {
        return storage.fruits.get(name);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : storage.fruits.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                         .append(entry.getKey())
                         .append(",")
                         .append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
