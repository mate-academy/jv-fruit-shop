package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ",";

    @Override
    public String getDataForReport() {
        StringBuilder dataForReport = new StringBuilder();
        dataForReport.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            dataForReport.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue().toString())
                    .append(System.lineSeparator());
        }
        return dataForReport.toString();
    }
}
