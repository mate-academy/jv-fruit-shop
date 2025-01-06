package db;

import java.util.HashMap;

public class Storage {
    private static final HashMap<String, Integer> db = new HashMap<>();

    public static HashMap<String, Integer> getDb() {
        return db;
    }

    boolean isDbEmpty() {
        return db.isEmpty();
    }
}
