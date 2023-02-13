package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.ReportCreatorService;
import java.util.stream.Collectors;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String COMMA = ",";
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
                .map(r -> System.lineSeparator()
                        + r.getKey()
                        + COMMA
                        + r.getValue())
                .collect(Collectors.joining());
    }
}
