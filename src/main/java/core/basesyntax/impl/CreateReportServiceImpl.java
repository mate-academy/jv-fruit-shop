package core.basesyntax.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.CreateReportService;
import java.util.Map;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String REPORT_HEAD = "fruit,quantity";
    private static final String REPORT_SPLITTER = ",";
    private static final String REPORT_SEPARATOR = System.lineSeparator();

    @Override
    public String createReport(Map<Fruit, Integer> reportMap) {
        StringBuilder report = new StringBuilder();
        report.append(REPORT_HEAD).append(REPORT_SEPARATOR);
        for (Map.Entry<Fruit, Integer> entry : reportMap.entrySet()) {
            report.append(entry.getKey().getName())
                    .append(REPORT_SPLITTER)
                    .append(entry.getValue())
                    .append(REPORT_SEPARATOR);
        }
        return report.toString();
    }
}
