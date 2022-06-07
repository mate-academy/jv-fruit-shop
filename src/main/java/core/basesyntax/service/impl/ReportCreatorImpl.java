package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.ReportCreator;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    private static final String DATA_SEPARATOR = ",";
    private static final String HEADING = "fruit,quantity";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private final StorageDao storageDao;

    public ReportCreatorImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String createReport() {
        return HEADING + storageDao.extractData()
                .entrySet()
                .stream()
                .map(entry -> LINE_SEPARATOR
                        + entry.getKey()
                        + DATA_SEPARATOR
                        + entry.getValue())
                .collect(Collectors.joining());
    }
}
