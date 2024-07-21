package service.impl;

import java.util.Map;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport(Storage storage) {
        StringBuilder report = new StringBuilder();
        Map<String, Integer> allStorage = storage.getAll();
        for (Map.Entry<String, Integer> entry : allStorage.entrySet()) {
            report.append(entry.getKey())
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
