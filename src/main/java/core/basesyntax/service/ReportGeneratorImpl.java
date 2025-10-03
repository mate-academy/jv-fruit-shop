package core.basesyntax.service;

import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String COMMA = ",";
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String FRUIT = "fruit";
    public static final String QUANTITY = "quantity";

    private final Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(FRUIT).append(COMMA).append(QUANTITY).append(LINE_SEPARATOR);

        for (Map.Entry<String, Integer> entry : storage.getAll().entrySet()) {
            report.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(LINE_SEPARATOR);
        }
        return report.toString();
    }
}
