package core.basesyntax.service;

import core.basesyntax.storage.Storage;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder()
                .append("fruit,quantity").append(System.lineSeparator());
        Storage.shop.forEach((f, q) -> report.append(f)
                .append(",").append(q).append(System.lineSeparator()));
        return report.toString();
    }
}
