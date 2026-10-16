package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.StringJoiner;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringJoiner report = new StringJoiner(System.lineSeparator());
        report.add("fruit,quantity");
        for (var entry : Storage.fruits.entrySet()) {
            report.add(entry.getKey() + "," + entry.getValue());
        }
        return report.toString();
    }
}
