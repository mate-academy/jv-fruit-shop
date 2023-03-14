package core.basesyntax.service.impl;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.db.dao.StorageDaoImpl;
import core.basesyntax.service.CreateReportService;
import java.util.ArrayList;
import java.util.List;

public class CreateReportServiceImpl implements CreateReportService {

    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public List<String> createReport() {
        List<String> report = new ArrayList<>();
        report.add(HEADER);
        for (String fruit : storageDao.getAll().keySet()) {
            report.add(fruit + SEPARATOR + storageDao.get(fruit));
        }
        return report;
    }
}
