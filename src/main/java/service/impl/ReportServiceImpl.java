package service.impl;

import db.Storage;
import db.StorageImpl;
import java.util.StringJoiner;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final Storage storage = new StorageImpl();
    private static final String TITLE = "fruit,quantity\n";

    @Override
    public String generateReport() {
        StringJoiner joiner = new StringJoiner(",\n");
        for (String fruit : storage.getKeys()) {
            joiner.add(fruit + "=" + storage.getValue(fruit));
        }
        return TITLE + joiner;
    }
}
