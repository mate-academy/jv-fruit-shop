package service.impl;

import dao.StorageDao;
import java.util.stream.Collectors;
import service.CreatorReportService;

public class CreatorReportServiceImpl implements CreatorReportService {
    private static final String FIRST_ROW = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private final StorageDao storageDao;

    public CreatorReportServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String createReport() {
        return FIRST_ROW + storageDao.getStorage()
                .entrySet()
                .stream()
                .map(s -> System.lineSeparator()
                        + s.getKey()
                        + SEPARATOR
                        + s.getValue())
                .collect(Collectors.joining());
    }
}
