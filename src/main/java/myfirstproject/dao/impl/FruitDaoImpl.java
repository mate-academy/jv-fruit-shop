package myfirstproject.dao.impl;

import java.util.HashMap;
import java.util.Map;
import myfirstproject.dao.FruitDao;
import myfirstproject.db.CustomDataBase;
import myfirstproject.model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void save(Fruit fruit, int value) {
        CustomDataBase.storage.put(fruit, value);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return new HashMap<>(CustomDataBase.storage);
    }

    @Override
    public Integer getQuantity(Fruit fruit) {
        return CustomDataBase.storage.get(fruit);
    }
}
