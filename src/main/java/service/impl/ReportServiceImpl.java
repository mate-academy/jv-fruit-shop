package service.impl;

import db.Storage;
import db.StorageImpl;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final Storage storage = new StorageImpl();
    private static final String TITLE = "fruit,quantity\n";

    @Override
    public String generateReport() {
        String receivedData = storage.getFromStorage()
                .substring(1, (storage.getFromStorage()).length() - 1);
        return TITLE + receivedData.replace(", ", ",\n");
    }
}
