package core.basesyntax.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruits = new HashMap<>();

    public static List<String[]> getAll() {
        List<String[]> fruitsList = new ArrayList<>();
        for (String key : Storage.fruits.keySet()) {
            fruitsList.add(new String[] {key, String.valueOf(fruits.get(key))});
        }
        return fruitsList;
    }

}
