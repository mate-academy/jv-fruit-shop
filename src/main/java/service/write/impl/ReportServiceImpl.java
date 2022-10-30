package service.write.impl;

import dao.StorageDao;
import dao.impl.StorageDaoImpl;
import java.util.Map;
import service.write.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String CSV_SEPARATOR = ",";
    private static final String START_MESSAGE = "fruit,quantity";
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(START_MESSAGE);
        storageDao.getAll().stream()
                .map(Map.Entry::getKey)
                .forEach(e -> stringBuilder.append(LINE_SEPARATOR)
                        .append(e)
                        .append(CSV_SEPARATOR)
                        .append(storageDao.getQuantity(e)));
        return stringBuilder.toString();
    }
}
