package core.basesyntax.report.report;

import core.basesyntax.model.FruitOperation;
import java.util.List;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "fruit,quantity";
    private final StringBuilder stringBuilder;

    public ReportGeneratorImpl() {
        stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER);
    }

    @Override
    public String getReport(List<FruitOperation> store) {
        for (FruitOperation fruitOperation : store) {
            stringBuilder.append(System.lineSeparator())
                    .append(fruitOperation.getFruit())
                    .append(SEPARATOR)
                    .append(fruitOperation.getQuantity());
        }
        return stringBuilder.toString();
    }
}
