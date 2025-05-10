package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String FIRST_LINE_OF_REPORT = "fruit,quantity";
    private static final String COMMA_SIGN = ",";

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(FIRST_LINE_OF_REPORT).append(System.lineSeparator());

        for (Map.Entry<String, Integer> pair : Storage.reports.entrySet()) {
            reportBuilder.append(pair.getKey())
                    .append(COMMA_SIGN)
                    .append(pair.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
