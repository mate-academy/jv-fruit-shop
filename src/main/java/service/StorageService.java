package service;

import java.util.List;
import java.util.Map;
import model.FruitRecord;

public interface StorageService {
    Map<String, Integer> processingData(List<FruitRecord> fruitRecordList);
}
