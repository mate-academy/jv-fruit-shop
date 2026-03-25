package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        convertToCsv(storage);
        return convertToCsv(storage);
    }

    @Override
    public String convertToCsv(Storage storage) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : storage.getAll().entrySet()) {
            report.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\n");

        }
        return report.toString();
    }

}
