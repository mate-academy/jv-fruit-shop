package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportMakerService;

public class ReportMakerServiceImpl implements ReportMakerService {
    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder("fruit,quantity\n");
        Storage.fruitStorage
                .forEach((key, value) -> report.append(key).append(",").append(value)
                        .append(System.lineSeparator()));
        return report.toString().trim();
    }
}
