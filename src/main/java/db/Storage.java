package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.fruitrecord.FruitRecord;

public class Storage {
    public static final List<FruitRecord> fruitStorageList = new ArrayList<>();
    public static final Map<String, Integer> storage = new HashMap<>();
}
