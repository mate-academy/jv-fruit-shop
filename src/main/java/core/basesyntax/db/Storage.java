package core.basesyntax.db;

import java.util.HashMap;

public class Storage {
    private static HashMap<String, Integer> db = new HashMap<>();

    public static HashMap<String, Integer> getDb() {
        return db;
    }

    public static void setDb(HashMap<String, Integer> db) {
        Storage.db = db;
    }
}
