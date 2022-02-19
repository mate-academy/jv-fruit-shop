package db;

import fruitrecord.FruitRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    public static final List<FruitRecord> records = new ArrayList<>();
    public static final Map<String, Integer> fruitsQuantity = new HashMap<>();
}

