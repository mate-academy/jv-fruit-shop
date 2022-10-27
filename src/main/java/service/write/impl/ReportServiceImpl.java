package service.write.impl;

import dao.StorageDao;
import dao.impl.StorageDaoImpl;
import db.Storage;
import java.util.Map;
import java.util.Set;
import service.write.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String CSV_SEPARATOR = ",";
    private static final String START_MESSAGE = "fruit,quantity";
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public String createReport() {
        Map<String, Integer> storage = storageDao.getAll();
        Set<String> keySet = storage.keySet();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(START_MESSAGE);
        for (String key : keySet) {
            stringBuilder.append(LINE_SEPARATOR)
                    .append(key)
                    .append(CSV_SEPARATOR)
                    .append(Storage.storage.get(key));
        }
        return stringBuilder.toString();
    }
}
