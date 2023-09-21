package core.basesyntax.servise.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.servise.ReportCreator;
import java.util.Map;

public class ReportCreatorImp implements ReportCreator {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder();
        report.append(HEADER);
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
