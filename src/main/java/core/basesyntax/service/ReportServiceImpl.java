package core.basesyntax.service;

import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String FIRST_LINE_REPORT_TEXT = "fruit,quantity";
    @Override
    public String createReport(Map<String, Integer> endOfDayQuantities) {
        StringBuilder report = new StringBuilder();
        report.append(FIRST_LINE_REPORT_TEXT);
        for (String productName : endOfDayQuantities.keySet()) {
            report.append(System.lineSeparator() + productName
                    + "," + endOfDayQuantities.get(productName));
        }
        return report.toString();
    }
}
