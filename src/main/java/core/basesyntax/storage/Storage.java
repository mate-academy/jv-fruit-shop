package core.basesyntax.storage;

import core.basesyntax.model.fruit.Record;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruitMap = new HashMap<>();

    public static void fillFruitMap(List<Record> records) {
        for (Record record : records) {
            if (!fruitMap.containsKey(record.getFruit())) {
                fruitMap.put(record.getFruit(), 0);
            }
        }
    }
}
