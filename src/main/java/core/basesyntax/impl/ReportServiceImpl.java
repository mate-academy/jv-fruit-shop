package core.basesyntax.impl;

import core.basesyntax.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER_INFORMATION = "fruit, quantity";

    @Override
    public String createReport(List<String> data) {
        StringBuilder builder = new StringBuilder(HEADER_INFORMATION + System.lineSeparator());
        for (String line: data) {
            builder.append(line).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
