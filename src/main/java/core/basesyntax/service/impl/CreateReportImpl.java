package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.CreateReport;
import java.util.stream.Collectors;

public class CreateReportImpl implements CreateReport {
    private static final String SPLITERATOR = ",";
    private static final String TITLE = "fruit,quantity";
    private final StorageDao storageDao;

    public CreateReportImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String reportCreate() {
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
