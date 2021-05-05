package core.basesyntax.service.implementation;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE_OF_OUTPUT_FILE = "fruit,quantity";

    @Override
    public String createReport(Map<String, Integer> storage) {
        StringBuilder report = new StringBuilder();
        report.append(TITLE_OF_OUTPUT_FILE);
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            report.append("\n").append(entry.getKey()).append(",").append(entry.getValue());
        }
        return report.toString();
    }
}
