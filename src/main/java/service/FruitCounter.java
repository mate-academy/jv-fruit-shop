package service;

import java.util.List;
import model.FruitRecord;

public interface FruitCounter {
    void countFruit(List<FruitRecord> fruitRecordList);
}
