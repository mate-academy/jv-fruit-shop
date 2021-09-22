package service;

import java.util.List;
import java.util.Map;
import model.FruitRecord;

public interface FruitCounter {
    Map<String, Integer> countFruit(List<FruitRecord> fruitRecordList);
}
