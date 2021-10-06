package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitRecord;

public class FruitServiceImpl implements FruitService {
    private Map<String, Integer> report = new HashMap<>();

    @Override
    public Map<String, Integer> getReport(List<FruitRecord> fruitRecords,
                                          ActivityStrategy activityStrategy) {
        for (FruitRecord fruitRecord : fruitRecords) {
            activityStrategy.select(fruitRecord.getActivityType()).use(fruitRecord, report);
        }
        return report;
    }
}
