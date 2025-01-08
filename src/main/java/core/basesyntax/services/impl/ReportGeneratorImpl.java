package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.ReportGenerator;
import java.util.List;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String COMMA = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public String getReport(List<FruitTransaction> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER).append(System.lineSeparator());
        for (FruitTransaction string : list) {
            stringBuilder.append(string.getFruit()).append(COMMA).append(string.getQuantity())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
