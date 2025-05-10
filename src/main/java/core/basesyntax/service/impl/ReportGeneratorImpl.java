package core.basesyntax.service.impl;

import core.basesyntax.db.StorageFruit;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String COMA = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();

        report.append(HEADER).append(System.lineSeparator());

        for (Map.Entry<String, Integer> entry : StorageFruit.storage.entrySet()) {
            report.append(entry.getKey()).append(COMA)
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return report.toString();
    }
}
