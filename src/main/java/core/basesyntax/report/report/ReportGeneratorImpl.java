package core.basesyntax.report.report;

import core.basesyntax.model.FruitOperation;
import java.util.List;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String DEFAULT_DELIMITER = ",";
    private static final String HEADER = "fruit" + DEFAULT_DELIMITER + "quantity";
    private final StringBuilder stringBuilder;

    public ReportGeneratorImpl() {
        stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER);
    }

    @Override
    public String getReport(List<FruitOperation> store) {
        for (FruitOperation fruitOperation : store) {
            stringBuilder.append(System.lineSeparator())
                    .append(fruitOperation.getOperation())
                    .append(DEFAULT_DELIMITER)
                    .append(fruitOperation.getQuantity());
        }
        return stringBuilder.toString();
    }
}
