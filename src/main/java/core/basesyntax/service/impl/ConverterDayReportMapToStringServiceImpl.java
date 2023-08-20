package core.basesyntax.service.impl;

import core.basesyntax.Main;
import core.basesyntax.service.ConverterDayReportMapToStringService;
import java.util.Map;

public class ConverterDayReportMapToStringServiceImpl
        implements ConverterDayReportMapToStringService {

    public static final String COMA_SEPARATOR = ",";

    @Override
    public String convertReportToString(Map<String, Integer> dayReportMap) {
        StringBuilder reportString = new StringBuilder(Main.REPORT_TITLE);
        for (Map.Entry<String, Integer> stringIntegerEntry : dayReportMap.entrySet()) {
            reportString.append(System.lineSeparator())
                    .append(stringIntegerEntry.getKey())
                    .append(COMA_SEPARATOR)
                    .append(stringIntegerEntry.getValue());
        }

        return reportString.toString();
    }
}
