package core.basesyntax.service;

import core.basesyntax.model.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("fruit,quantity").append(System.lineSeparator());
        Map<String, Integer> storageData = Storage.getFullStorage();
        for (Map.Entry<String, Integer> entry : storageData.entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
