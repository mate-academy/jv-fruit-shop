package service;

import fruitrecord.FruitRecord;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private ActivitiesStrategy strategy;

    public FruitServiceImpl(ActivitiesStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void recordToMap(List<FruitRecord> fruitRecords) {
        for (FruitRecord fruitRecord : fruitRecords) {
            strategy.get(fruitRecord.getOperationType())
                    .apply(fruitRecord);
        }
    }
}
