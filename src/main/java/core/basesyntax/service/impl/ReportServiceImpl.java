package core.basesyntax.service.impl;

import core.basesyntax.dataprocess.DataProcessor;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String CSV_HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    public String generateReport(DataProcessor dataProcessor) {
        Map<String, Integer> fruitData = dataProcessor.getFruitData();
        StringBuilder reportBuilder = new StringBuilder(CSV_HEADER)
                .append(System.lineSeparator());

        fruitData.forEach((fruit, quantity) ->
                reportBuilder.append(fruit).append(SEPARATOR)
                        .append(quantity).append(System.lineSeparator()));

        return reportBuilder.toString();
    }
}
