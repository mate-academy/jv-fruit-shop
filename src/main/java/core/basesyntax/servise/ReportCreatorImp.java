package core.basesyntax.servise;

import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportCreatorImp implements ReportCreator {
    private static final String SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity");
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            report.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue());
        }
        return report.toString();
    }
}
