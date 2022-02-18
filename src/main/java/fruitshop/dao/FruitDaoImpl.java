package fruitshop.dao;

import fruitshop.db.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void addToStorage(String key, Integer value) {
        Storage.fruitList.put(key, value);
    }

    @Override
    public void addValue(String key, Integer value) {
        Integer newValue = Storage.fruitList.get(key) + value;
        Storage.fruitList.put(key, newValue);
    }

    @Override
    public void subtractValue(String key, Integer value) {
        Integer newValue = Storage.fruitList.get(key) - value;
        Storage.fruitList.put(key, newValue);
    }
}
