package core.basesyntax.dao;

import static core.basesyntax.db.Storage.STORAGE;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public class FruitDaoImp implements FruitDao {
    public Map<String, Integer> getStorage() {
        return STORAGE;
    }

    public void add(String type, Integer quantity) {
        STORAGE.put(type, quantity);
    }

    @Override
    public void add(List<FruitTransaction> list) {
        for (FruitTransaction item : list) {
            STORAGE.put(item.getFruit(), 0);
        }
    }

    public Integer get(String key) {
        return STORAGE.get(key);
    }
}
