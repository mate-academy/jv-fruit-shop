package service.impl;

import dao.StorageDao;
import java.util.stream.Collectors;
import service.ReportCreatorService;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String SPLITERATOR = ",";
    private static final String TITLE = "fruit,quantity";
    private final StorageDao storageDao;

    public ReportCreatorServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String createReport() {
        return TITLE + storageDao.getStorage()
                .entrySet()
                .stream()
                .map(e -> System.lineSeparator()
                        + e.getKey()
                        + SPLITERATOR
                        + e.getValue())
                .collect(Collectors.joining());
    }
}
