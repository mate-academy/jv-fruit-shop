package core.report;

import core.db.Storage;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String TITLE = "fruit,quantity";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(TITLE).append(LINE_SEPARATOR);

        for (Map.Entry<String, Integer> entry : Storage.getAll().entrySet()) {
            builder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(LINE_SEPARATOR);
        }

        return builder.toString();
    }
}
