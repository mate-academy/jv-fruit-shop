package core.basesyntax.report;

import java.util.Map;

import static core.basesyntax.model.FruitStorage.storage;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String CSV_HEADER = "fruit,quantity";
    private static final String CSV_SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();

        report.append(CSV_HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            report.append(entry.getKey())
                    .append(CSV_SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
