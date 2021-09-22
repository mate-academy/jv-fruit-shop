package core.db;

import core.model.FruitRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> stockStorage = new HashMap<>();
    private static List<FruitRecord> listFruits = new ArrayList<>();

    public static List<FruitRecord> getListFruits() {
        return listFruits;
    }
}
