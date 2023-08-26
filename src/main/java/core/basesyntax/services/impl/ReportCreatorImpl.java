package core.basesyntax.services.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String COMMA = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder().append(FIRST_LINE).append(LINE_SEPARATOR);
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            report.append(entry.getKey()).append(COMMA)
                    .append(entry.getValue()).append(LINE_SEPARATOR);
        }
        return report.toString();
    }
}
