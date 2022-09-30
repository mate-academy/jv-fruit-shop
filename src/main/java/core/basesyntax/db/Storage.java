package core.basesyntax.db;

import java.util.HashMap;

public class Storage {
    private static final HashMap<String, Integer> fruits = new HashMap<>();

    public static HashMap<String, Integer> getFruits() {
        return fruits;
    }
}
