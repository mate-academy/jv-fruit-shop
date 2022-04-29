package db;

import core.basesyntax.FruitTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    public static Map<String, List<FruitTransaction>> MapDataBase = new HashMap<>();
    // must be private
    public static Map<String, Integer> MapDataBaseReport = new HashMap<>();
    // it's too
}
