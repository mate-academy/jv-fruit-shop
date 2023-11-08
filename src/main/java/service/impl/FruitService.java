package service.impl;

import java.util.List;
import java.util.Map;
import model.FruitRecord;

public interface FruitService {
    Map<String, Integer> getReport(List<FruitRecord> fruitRecords,
                                   ActivityStrategy activityStrategy);
}
