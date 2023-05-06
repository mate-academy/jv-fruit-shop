package service.impl;

import dao.StorageDao;
import java.util.stream.Collectors;
import service.ReportCreatorService;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String FIRST_ROW = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private final StorageDao storageDao;

    public ReportCreatorServiceImpl(StorageDao storageDao) {
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
