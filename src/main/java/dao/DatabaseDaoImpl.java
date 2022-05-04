package dao;

import db.Database;
import java.util.Map;

public class DatabaseDaoImpl implements DatabaseDao {
    @Override
    public void addFruit(String fruit, Integer quantity) {
        Database.database.put(fruit, quantity);
    }

    @Override
    public Map<String, Integer> getAllFruits() {
        return Database.database;
    }
}
