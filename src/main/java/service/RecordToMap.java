package service;

import java.util.List;
import service.fruitrecord.FruitRecord;

public interface RecordToMap {
    void recordToMap(List<FruitRecord> fruitRecordList, ActivitiesStrategy strategy);
}
