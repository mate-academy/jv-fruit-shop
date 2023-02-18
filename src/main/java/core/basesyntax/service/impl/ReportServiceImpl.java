package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    @Override
    public String getReportFruitStorage(String information) {
        StringBuilder builder = new StringBuilder("fruit,quantity");
        builder.append(System.lineSeparator()).append(information);
        return builder.toString();
    }
}
