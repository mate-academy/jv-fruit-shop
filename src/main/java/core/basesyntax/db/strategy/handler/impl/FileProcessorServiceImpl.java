package core.basesyntax.db.strategy.handler.impl;

import core.basesyntax.db.service.FIleProcessorService;
import java.util.Map;

public class FileProcessorServiceImpl implements FIleProcessorService {
    @Override
    public String getReport(Map<String, Integer> map) {
        StringBuilder report = new StringBuilder("fruit, quantity").append(System.lineSeparator());
        for (Map.Entry entry: map.entrySet()) {
            report.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
