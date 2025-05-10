package core.basesyntax.report;

import core.basesyntax.storage.FruitStorage;

public class ReportBuilderImpl implements ReportBuilder {
    private static final String REPORT_HEADER = "fruit,quantity";

    @Override
    public String buildReport(FruitStorage storage) {
        StringBuilder report = new StringBuilder();
        report.append(REPORT_HEADER)
                .append(System.lineSeparator());
        storage.getAllFruits().forEach((fruit, quantity) -> {
            report.append(fruit)
                    .append(",")
                    .append(quantity)
                    .append(System.lineSeparator());
        });
        return report.toString();
    }
}
