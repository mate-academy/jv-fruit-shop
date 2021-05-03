package storage;

import java.util.HashMap;
import java.util.Map;
import model.Fruit;

public class Db {
    private static Map<Fruit, Integer> dataBase = new HashMap<>();

    public Db(Map<Fruit, Integer> dataBase) {
        Db.dataBase = dataBase;
    }

    public static Map<Fruit, Integer> getDataBase() {
        return dataBase;
    }
}
