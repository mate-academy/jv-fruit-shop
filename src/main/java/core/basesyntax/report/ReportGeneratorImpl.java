package core.basesyntax.report;

import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String LINE_SEPARATOR = ",";

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(HEADER).append(System.lineSeparator());

        for (Map.Entry<String, Integer> entry : Storage.getAll().entrySet()) {
            builder.append(entry.getKey())
                    .append(LINE_SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
