package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.ReportCreator;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    private static final String SEPARATOR = ",";
    private static final String REPORT_HEADER = "fruit,quantity";
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public String createReport() {
        return storageDao.getALl().entrySet().stream()
                .map(e -> e.getKey().getName() + SEPARATOR + e.getValue())
                .collect(Collectors.joining(System.lineSeparator(),
                        REPORT_HEADER + System.lineSeparator(), ""));
    }
}
