package myfirstproject.dao.impl;

import java.util.HashMap;
import java.util.Map;
import myfirstproject.dao.DataBaseDao;
import myfirstproject.db.CustomDataBase;
import myfirstproject.model.Fruit;

public class DataBaseDaoImpl implements DataBaseDao {
    @Override
    public void saveDataToCustomDB(Fruit fruit, int value) {
        CustomDataBase.storage.put(fruit, value);
    }

    @Override
    public Map<Fruit, Integer> getAllRecords() {
        return new HashMap<>(CustomDataBase.storage);
    }

    @Override
    public Integer getRecordFromDB(Fruit fruit) {
        return CustomDataBase.storage.get(fruit);
    }
}
