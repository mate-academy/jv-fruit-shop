package service;

import db.Storage;
import java.util.stream.Collectors;

public class ReportService {
    private static final String COMMA = ",";

    public String generateReport() {
        return Storage.getStorage().entrySet().stream()
                .map(line -> line.getKey() + COMMA + line.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
