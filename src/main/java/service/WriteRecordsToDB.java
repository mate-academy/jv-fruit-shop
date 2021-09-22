package service;

import java.util.List;
import fruitrecord.FruitRecord;

public interface WriteRecordsToDB {
    void recordToMap(List<FruitRecord> fruitRecordList, ActivitiesStrategy strategy);
}
