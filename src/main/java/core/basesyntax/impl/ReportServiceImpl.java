package core.basesyntax.impl;

import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String DEFAULT_INFORMATION = "fruit,quantity";

    @Override
    public String createReport(List<String> information) {
        StringBuilder stringBuilder = new StringBuilder(DEFAULT_INFORMATION
                + System.lineSeparator());
        for (String record : information) {
            stringBuilder.append(record).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
