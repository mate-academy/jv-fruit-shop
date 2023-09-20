package service.impl;

import data.base.Storage;

public class ReportGeneratorServiceImpl {
    private static final String HEADER = "fruit,quantity";
    private static final String SPLITTER = ",";
    private final StringBuilder reportBuilder = new StringBuilder();

    public String createReport() {
        reportBuilder.append(HEADER).append(System.lineSeparator());
        Storage.STORAGE.forEach((key, value) -> reportBuilder.append(key)
                .append(SPLITTER)
                .append(value)
                .append(System.lineSeparator()));
        return reportBuilder.toString();
    }
}

