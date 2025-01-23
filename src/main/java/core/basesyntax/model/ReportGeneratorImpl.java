package core.basesyntax.model;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.StringJoiner;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String getReport() {
        StringJoiner report = new StringJoiner(System.lineSeparator());
        report.add(HEADER);

        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            report.add(entry.getKey() + SEPARATOR + entry.getValue());
        }

        return report.toString();
    }
}
