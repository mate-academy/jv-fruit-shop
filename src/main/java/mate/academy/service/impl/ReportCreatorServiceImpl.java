package mate.academy.service.impl;

import java.util.Map;
import mate.academy.service.ReportCreatorService;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    @Override
    public String createReport(Map<String, Integer> fruits) {
        StringBuilder report = new StringBuilder("fruit,quantity" + System.lineSeparator());
        for (Map.Entry<String, Integer> entry: fruits.entrySet()) {
            report.append(entry.getKey()).append(",")
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return report.toString();
    }
}
