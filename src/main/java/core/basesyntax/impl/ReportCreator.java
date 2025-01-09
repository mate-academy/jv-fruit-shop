package core.basesyntax.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.service.CreateReport;
import java.util.Map;

public class ReportCreator implements CreateReport {
    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder().append("fruit,quantity")
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            report.append(entry.getKey()).append(",")
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return report.toString();
    }
}
