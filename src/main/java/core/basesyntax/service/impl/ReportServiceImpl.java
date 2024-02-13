package core.basesyntax.service.impl;

import core.basesyntax.dataprocess.DataProcessor;
import core.basesyntax.service.ReportService;
import java.util.HashMap;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public Map<String, Integer> generateReport(DataProcessor dataProcessor) {
        Map<String, Integer> fruitData = dataProcessor.getFruitData();
        return new HashMap<>(fruitData);
    }
}
