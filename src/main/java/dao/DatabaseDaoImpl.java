package dao;

import db.Database;
import java.util.Map;

public class DatabaseDaoImpl implements DatabaseDao {
    @Override
    public void addAllFruits(Map<String, Integer> fruitList) {
        Database.database.putAll(fruitList);
    }

    @Override
    public Map<String, Integer> getAllFruits() {
        return Database.database;
    }
}
