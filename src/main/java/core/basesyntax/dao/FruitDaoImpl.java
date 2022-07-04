package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(String name, Integer amount) {
        Storage.fruitStorage.put(name, amount);
    }

    @Override
    public Optional<Integer> get(String name) {
        return Optional.ofNullable(Storage.fruitStorage.get(name));
    }

    @Override
    public Map<String, Integer> getAll() {
        return new HashMap<>(Storage.fruitStorage);
    }
}
