package service.impl;

import db.Storage;
import java.util.List;
import service.CreatReport;

public class ReportCreator implements CreatReport {
    private static final String SPLITERATOR = ",";

    @Override
    public List<String> creatReport() {
        return Storage.storage.entrySet().stream()
                .map(e -> "" + e.getKey() + SPLITERATOR + e.getValue() + System.lineSeparator())
                .toList();
    }
}
