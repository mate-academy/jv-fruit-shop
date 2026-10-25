package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(HEADER);

        Map<String, Integer> fruits = Storage.getAll();

        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            String fruit = entry.getKey();
            Integer quantity = entry.getValue();

            report.append(System.lineSeparator());
            report.append(fruit);
            report.append(SEPARATOR);
            report.append(quantity);
        }

        return report.toString();
    }
}
