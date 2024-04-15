package service.impl;

import service.FileReaderService;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String STORAGE_PATH = "src/main/java/db/storage.csv";
    private static final FileReaderService readFile = new FileReaderServiceImpl();
    private static final String TITLE = "fruit,quantity\n";

    @Override
    public String generateReport() {
        String receivedData = readFile.read(STORAGE_PATH)
                .substring(1, (readFile.read(STORAGE_PATH)).length() - 1);
        return TITLE + receivedData.replace(", ", ",\n");
    }
}
