package core.basesyntex.service.impl;

import core.basesyntex.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        Map<String, Integer> allStorage = Storage.getAll();
        for (Map.Entry<String, Integer> entry : allStorage.entrySet()) {
            report.append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
