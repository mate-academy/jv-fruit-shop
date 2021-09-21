package Service;

import Service.fruitRecord.FruitRecord;

import java.util.List;

public interface RecordToMap {
    void recordToMap(List<FruitRecord> fruitRecordList, ActivitiesStrategy strategy);
}
