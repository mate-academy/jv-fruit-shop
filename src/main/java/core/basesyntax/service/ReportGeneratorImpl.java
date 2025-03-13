package core.basesyntax.service;

import core.basesyntax.service.db.Storage;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String BANANA = "banana";
    private static final String APPLE = "apple";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity")
                .append("\n")
                .append("banana,")
                .append(Storage.fruits.get(BANANA))
                .append("\n")
                .append("apple,")
                .append(Storage.fruits.get(APPLE))
                .append("\n");
        return report.toString();
    }
}
