package db;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    public static final Map<LocalDate, Map<String, Integer>> fruitStorage = new HashMap<>();
}
