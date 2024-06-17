package service.report;

import database.Storage;

public class CreateReportImpl implements CreateReport {

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit").append(",").append("quantity").append(System.lineSeparator());

        Storage.storage.forEach((fruit, quantity) -> report
                .append(fruit).append(",").append(quantity).append(System.lineSeparator()));
        return report.toString();
    }
}
