package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private StorageDao storageDao;

    public ReportServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String createReport() {
        return "fruit,quantity" + System.lineSeparator() +
                storageDao.getAll().entrySet().stream()
                        .map(entry -> entry.getKey() + "," + entry.getValue())
                        .collect(Collectors.joining(System.lineSeparator()));

    }
}
