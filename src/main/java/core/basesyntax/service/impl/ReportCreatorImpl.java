package core.basesyntax.service.impl;

import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String TITLE_ROW = "\t"
            + "fruit,quantity"
            + System.lineSeparator();
    private static final String ROW_SEPARATOR = ",";

    @Override
    public String reportCreator(Map<String, Integer> inputData) {
        StringBuilder reportBuilder = new StringBuilder(TITLE_ROW);
        for (Map.Entry<String, Integer> inputDataEntry : inputData.entrySet()) {
            reportBuilder.append("\t")
                    .append(inputDataEntry.getKey())
                    .append(ROW_SEPARATOR)
                    .append(inputDataEntry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
