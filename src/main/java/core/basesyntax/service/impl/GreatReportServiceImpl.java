package core.basesyntax.service.impl;

import core.basesyntax.service.GreatReportService;
import java.util.HashMap;

public class GreatReportServiceImpl implements GreatReportService {
    private static final String SEPARATOR_IN_LINE = ", ";
    private static final StringBuilder stringBuilderReport = new StringBuilder();

    @Override
    public String generateReport(HashMap<String, Integer> db) {
        for (String key : db.keySet()) {
            stringBuilderReport
                    .append(key)
                    .append(SEPARATOR_IN_LINE)
                    .append(db.get(key))
                    .append(System.lineSeparator());
        }
        return stringBuilderReport.toString();
    }
}
