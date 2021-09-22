package service;

import java.util.List;
import fruitrecord.FruitRecord;

public class WriteRecordsToDbImpl implements WriteRecordsToDB {
    @Override
    public void recordToMap(List<FruitRecord> fruitRecordList, ActivitiesStrategy strategy) {
        for (FruitRecord fruitRecord : fruitRecordList) {
            strategy.get(fruitRecord.getOperationType())
                    .apply(fruitRecord);
        }
    }
}
