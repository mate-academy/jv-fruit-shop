package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportMakerService;

public class ReportMakerServiceImpl implements ReportMakerService {
    private static final StringBuilder REPORT = new StringBuilder("fruit,quantity\n");
    @Override
    public String createReport() {
        Storage.FRUIT_STORAGE
                .forEach((key, value) -> REPORT.append(key).append(",").append(value).append("\n"));
        return REPORT.toString().trim();
    }
}
