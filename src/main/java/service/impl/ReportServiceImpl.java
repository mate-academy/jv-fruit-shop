package service.impl;

import db.Storage;
import java.util.stream.Collectors;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity";
    private static final String COMA = ",";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(TITLE)
                .append(System.lineSeparator());
        Storage.storage.entrySet().stream()
                .map(fruit -> builder.append(fruit.getKey()).append(COMA)
                        .append(fruit.getValue())
                        .append(System.lineSeparator()))
                .collect(Collectors.joining());
        return builder.toString();
    }
}
