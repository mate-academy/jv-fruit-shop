package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ", ";

    @Override
    public String makeReport() {
        StringBuilder report = new StringBuilder();
        for (String element: Storage.storage.keySet()) {
            report.append(element)
                    .append(SEPARATOR)
                    .append(Storage.storage.get(element))
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
