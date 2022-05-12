package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.ReportCreator;
import java.util.stream.Collectors;

public class ReportCreatorImpl implements ReportCreator {
    private final StorageDao storageDao;

    public ReportCreatorImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String createReport() {
        return "fruit,quantity\n" + storageDao.getAll().stream()
                .filter(i -> i.getKey() != null && i.getValue() != null)
                .map(i -> i.getKey().getFruit()
                        + "," + i.getValue()
                        + System.lineSeparator())
                .collect(Collectors.joining());
    }
}
