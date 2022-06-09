package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    @Override
    public String getReport(String leftovers) {
        return "fruit,quantity"
                + System.lineSeparator()
                + leftovers;
    }
}
