package service.impl;

import db.Storage;
import service.ReportService;

import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {

    @Override
    public String makeReport() {
        return Storage.fruits.entrySet().stream()
                .map(e -> e.getKey() + "," + e.getValue() + System.lineSeparator())
                .collect(Collectors.joining());
    }
}
