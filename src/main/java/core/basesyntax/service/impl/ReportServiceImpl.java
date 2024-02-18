package core.basesyntax.service.impl;

import static core.basesyntax.db.Storage.fruitData;

import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String CSV_HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    public String generateReport() {

        StringBuilder reportBuilder = new StringBuilder(CSV_HEADER)
                .append(System.lineSeparator());

        fruitData.forEach((fruit, quantity) ->
                reportBuilder.append(fruit).append(SEPARATOR)
                        .append(quantity).append(System.lineSeparator()));

        return reportBuilder.toString();
    }
}
