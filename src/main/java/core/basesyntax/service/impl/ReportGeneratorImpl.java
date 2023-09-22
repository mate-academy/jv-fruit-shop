package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String makeReport() {
        StringBuilder report = new StringBuilder();
        for (String element: Storage.result.keySet()) {
            report.append(element)
                    .append(", ")
                    .append(Storage.result.get(element))
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
