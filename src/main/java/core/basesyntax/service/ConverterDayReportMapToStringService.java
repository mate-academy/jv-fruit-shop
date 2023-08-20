package core.basesyntax.service;

import java.util.Map;

public interface ConverterDayReportMapToStringService {
    String convertReportToString(Map<String, Integer> dayReportMap);
}
