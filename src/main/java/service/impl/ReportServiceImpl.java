package service.impl;

import db.Storage;
import java.util.stream.Collectors;
import service.ReportService;

public class ReportServiceImpl implements ReportService {

    @Override
    public String makeReport() {
        return Storage.fruits.entrySet().stream()
                .map(e -> e.getKey() + "," + e.getValue() + System.lineSeparator())
                .collect(Collectors.joining());
    }
}
