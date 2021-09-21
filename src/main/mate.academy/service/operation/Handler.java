package service.operation;

import model.Fruit;
import model.FruitRecord;
import java.util.Map;

public interface Handler {
    int changeAmount(FruitRecord fruitRecord, Map<Fruit, Integer> storage);
}
