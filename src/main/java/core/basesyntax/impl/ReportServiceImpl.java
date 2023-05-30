package core.basesyntax.impl;

import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity";

    @Override
    public List<String> report(List<String> data) {
        List<String> createdReport = new ArrayList<>();
        createdReport.add(TITLE);
        createdReport.addAll(data);
        return createdReport;
    }
}
