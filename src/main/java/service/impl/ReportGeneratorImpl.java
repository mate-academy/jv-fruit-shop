package service.impl;

import db.Storage;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String COMMA = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder sb = new StringBuilder(HEADER).append(System.lineSeparator());
        Storage.getFruits().forEach((key, value) ->
                sb.append(key).append(COMMA)
                .append(value).append(System.lineSeparator()));
        return sb.toString();
    }
}
