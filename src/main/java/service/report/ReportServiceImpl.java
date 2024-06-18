package service.report;

import database.Storage;

public class ReportServiceImpl implements ReportService {
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";
    private static final String COMMA = ",";

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(FRUIT).append(COMMA).append(QUANTITY).append(System.lineSeparator());

        Storage.storage.forEach((fruit, quantity) -> report
                .append(fruit).append(",").append(quantity).append(System.lineSeparator()));
        return report.toString();
    }
}
