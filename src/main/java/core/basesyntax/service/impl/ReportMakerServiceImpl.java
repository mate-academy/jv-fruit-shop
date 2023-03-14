package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportMakerService;

public class ReportMakerServiceImpl implements ReportMakerService {
    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder("fruit,quantity\n");
        Storage.fruitsStorage
                .forEach((key, value) -> report.append(key).append(",").append(value).append("\n"));
        return report.toString().trim();
    }
}
