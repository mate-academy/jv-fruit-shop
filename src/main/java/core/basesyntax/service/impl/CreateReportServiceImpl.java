package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.CreateReportService;
import java.util.Map;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String TITLE = "fruit,quantity";

    @Override
    public String formReport() {
        StringBuilder report = new StringBuilder();
        report.append(TITLE).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            report.append(entry.getKey().getName()).append(",").append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
