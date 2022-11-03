package myfirstproject.dao;

import java.util.Map;
import myfirstproject.model.Fruit;

public interface DataBaseDao {
    void saveDataToCustomDB(Fruit fruit, int value);

    Map<Fruit, Integer> getAllRecords();

    Integer getRecordFromDB(Fruit fruit);
}
