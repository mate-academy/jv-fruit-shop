package Service;

import Service.fruitRecord.FruitRecord;

import java.util.List;
import java.util.Map;

public class RecordToMapImpl implements RecordToMap {

    @Override
    public void recordToMap(List<FruitRecord> fruitRecordList, ActivitiesStrategy strategy) {
        for(FruitRecord fruitRecord : fruitRecordList) {
            strategy.get(fruitRecord.getOperationType()).setBalance(fruitRecord.getFruit(),fruitRecord.getAmount());

        }

    }
}
