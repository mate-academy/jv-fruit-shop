package core.basesyntax.report;

import core.basesyntax.storage.FruitStorage;

public class ReportBuilderImpl implements ReportBuilder {
    @Override
    public String buildReport(FruitStorage storage) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity\n");
        storage.getAllFruits().forEach((fruit, quantity) -> {
            report.append(fruit).append(",").append(quantity).append("\n");
        });
        return report.toString();
    }
}
