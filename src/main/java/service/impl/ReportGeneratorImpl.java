package service.impl;

import db.Storage;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder("fruit,quantity\n");
        Storage.getStorage().forEach((fruit, quantity) ->
                report.append(fruit).append(",").append(quantity).append("\n"));
        return report.toString();
    }
}
