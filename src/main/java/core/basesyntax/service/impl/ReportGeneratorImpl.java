package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        Map<String, Integer> fruits = Storage.getFruits();
        StringBuilder reportBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }

        return reportBuilder.toString().trim();
    }
}
