package core.basesyntax.services.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.interfaces.ReportInfoService;

public class ReportInfoServiceImpl implements ReportInfoService {
    private static final String TITLE = "fruit,quantity";
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public String createReportInfo() {
        StringBuilder report = new StringBuilder();
        report.append(TITLE).append(System.lineSeparator());

        Storage.fruits.forEach((fruit, quantity) -> report.append(fruit)
                .append(COMMA_SEPARATOR)
                .append(quantity)
                .append(System.lineSeparator()));

        return report.toString();
    }
}