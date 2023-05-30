package service.impl;

import db.Storage;
import java.util.stream.Collectors;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String SEPARATOR = ", ";

    @Override
    public String createReport() {
        return Storage.fruitStorage.entrySet().stream()
                .map(entry -> entry.getKey() + SEPARATOR + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator(),
                        "fruit, quantity" + System.lineSeparator(), System.lineSeparator()));
    }
}
