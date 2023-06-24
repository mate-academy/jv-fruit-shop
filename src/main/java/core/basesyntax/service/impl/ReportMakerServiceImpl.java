package core.basesyntax.service.impl;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.db.dao.StorageDaoImpl;
import core.basesyntax.service.ReportMakerService;
import java.util.ArrayList;
import java.util.List;

public class ReportMakerServiceImpl implements ReportMakerService {
    private final String header;
    private final String separator;
    private final StorageDao storageDao;

    public ReportMakerServiceImpl(String header, String separator) {
        this.header = header;
        this.separator = separator;
        storageDao = new StorageDaoImpl();
    }

    @Override
    public List<String> createReport() {
        List<String> report = new ArrayList<>();
        report.add(header);
        for (String fruit : storageDao.getAll().keySet()) {
            report.add(fruit + separator + storageDao.get(fruit));
        }
        return report;
    }
}
