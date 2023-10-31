package core.basesyntax.Dao;

import core.basesyntax.model.FruitTransaction;

import java.util.List;
import java.util.Map;

import static core.basesyntax.db.Storage.storage;

public class FruitDaoImp implements FruitDao {
    public Map<String, Integer> getStorage() {
        return storage;
    }
    public void add(String type, Integer quantity){
        storage.put(type, quantity);
    }

    @Override
    public void add(List<FruitTransaction> list) {
        for (FruitTransaction item : list) {
            storage.put(item.getFruit(), 0);
        }
    }

    public Integer get(String key) {
        return storage.get(key);
    }
}
