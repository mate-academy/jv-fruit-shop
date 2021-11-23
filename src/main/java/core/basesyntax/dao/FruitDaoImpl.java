package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public Integer getBalance(Fruit fruit) {
        return Storage.storage.entrySet().stream()
                .filter(e -> e.getKey().equals(fruit))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(0);
    }

    @Override
    public Integer add(Fruit fruit, Integer amount) {
        Storage.storage.put(fruit, getBalance(fruit) + amount);
        return Storage.storage.get(fruit);
    }

    @Override
    public Map<Fruit, Integer> getStorage() {
        return Storage.storage;
    }
}

