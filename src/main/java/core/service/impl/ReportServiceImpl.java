package core.service.impl;

import core.db.Storage;
import core.service.ReportService;

import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity\n";
    private static final String SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(TITLE);
        Storage.storage.entrySet().stream()
                .map(fruit -> builder.append(fruit.getKey()).append(SEPARATOR).append(fruit.getValue()).append(System.lineSeparator()))
                .collect(Collectors.joining());
        return builder.toString();
    }
}
