package core.basesyntax.serviceimpl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.storage.Storage;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String FIRST_LINE = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder resultingReport = new StringBuilder();
        resultingReport.append(FIRST_LINE);
        for (Fruit fruit : Storage.fruits) {
            resultingReport.append(System.lineSeparator())
                    .append(fruit.getFruit()).append(",").append(fruit.getQuantity());
        }
        return resultingReport.toString();
    }
}
