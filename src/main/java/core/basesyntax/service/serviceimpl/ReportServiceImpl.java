package core.basesyntax.service.serviceimpl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private final StorageDao storageDao;

    public ReportServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append(TITLE);
        storageDao.getAll().stream()
                .map(item -> item.getName() + SEPARATOR + item.getQuantity())
                .forEach(string -> report.append(System.lineSeparator()).append(string));
        return report.toString();
    }
}
