package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreatorService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final int DEFAULT_VALUE = 0;

    @Override
    public Map<String, Integer> createReport(List<Fruit> toReport) {
        Map<String, Integer> nameToAgeSum = new HashMap<>();
        for (Fruit report : toReport) {
            String fruitName = report.getFruit();
            int fruitQuantity = report.getQuantity();
            nameToAgeSum.put(fruitName, nameToAgeSum
                    .getOrDefault(fruitName, DEFAULT_VALUE) + fruitQuantity);
        }
        return nameToAgeSum;
    }
}
