package core.basesyntax.service.impl;

import core.basesyntax.db.FruitDb;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl
        implements ReportService {
    public static final String COMA_SEPARATOR = ",";
    public static final String REPORT_TITLE = "fruit,quantity";

    @Override
    public String getReport() {
        Map<String, Integer> dayReportMap = FruitDb.getBalanceMap();

        StringBuilder reportString = new StringBuilder(REPORT_TITLE);
        for (Map.Entry<String, Integer> stringIntegerEntry : dayReportMap.entrySet()) {
            reportString.append(System.lineSeparator())
                    .append(stringIntegerEntry.getKey())
                    .append(COMA_SEPARATOR)
                    .append(stringIntegerEntry.getValue());
        }

        return reportString.toString();
    }
}
