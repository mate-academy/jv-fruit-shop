package service.impl.activity;

import java.util.Map;
import model.FruitRecord;

public interface ActivityHandler {
    void use(FruitRecord fruitRecord, Map<String, Integer> report);
}
