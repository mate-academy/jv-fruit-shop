package service.impl;

import database.Storage;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String TITLE = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE).append(System.lineSeparator());
        Storage.getAssortment().forEach((key, value) -> stringBuilder.append(key).append(",")
                .append(value).append(System.lineSeparator()));
        return stringBuilder.toString();
    }
}
