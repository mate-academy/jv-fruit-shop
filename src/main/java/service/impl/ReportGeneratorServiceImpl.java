package service.impl;

import data.base.Storage;
import java.util.List;
import service.ReportGeneratorService;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String HEADER = "fruit,quantity";
    private static final String SPLITTER = ",";
    private final StringBuilder reportBuilder = new StringBuilder();

    @Override
    public String createReport() {
        reportBuilder.append(HEADER).append(System.lineSeparator());
        Storage.STORAGE.forEach((key, value) -> reportBuilder.append(key)
                .append(SPLITTER)
                .append(value)
                .append(System.lineSeparator()));
        return reportBuilder.toString();
    }

    @Override
    public List<String> generateReport() {
        return null;
    }
}
