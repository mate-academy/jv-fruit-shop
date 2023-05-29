package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE_INFORMATION = "fruit,quantity";

    @Override
    public List<String> createReport(List<String> information) {
        List<String> lines = new ArrayList<>();
        lines.add(TITLE_INFORMATION);
        for (String record : information) {
            lines.add(record);
        }
        return lines;
    }
}
