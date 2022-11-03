package services.impl;

import db.Storage;
import java.util.stream.Collectors;
import services.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String COLUMNS_NAME = "fruit,quantity";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder(COLUMNS_NAME);
        report.append(System.lineSeparator())
                .append(Storage.fruitList.stream()
                        .map(f -> String.format("%s,%d", f.getName(), f.getAmount()))
                        .collect(Collectors.joining(System.lineSeparator())));
        return report.toString();
    }
}
