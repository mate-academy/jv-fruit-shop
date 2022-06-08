package core.dao;

import core.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void update(String fruitName, int quantity) {
        Storage.fruitsMap.put(fruitName,quantity);
    }

    @Override
    public int get(String fruitName) {
        return Storage.fruitsMap.get(fruitName);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruitsMap;
    }
}
