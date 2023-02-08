package core.basesyntax.db;

import core.basesyntax.model.FruitRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    public static final List<FruitRecord> fruitRecordList = new ArrayList<>();
    public static final Map<String, Integer> fruitMap = new HashMap<>();
}
