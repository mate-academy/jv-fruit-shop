package core.basesyntax.service.impl;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.db.dao.StorageDaoImpl;
import core.basesyntax.service.ReportMakerService;
import java.util.ArrayList;
import java.util.List;

public class ReportMakerServiceImpl implements ReportMakerService {
    private final String delimiter;
    private final String header;
    private final StorageDao storageDao;

    public ReportMakerServiceImpl(String delimiter, String header) {
        this.delimiter = delimiter;
        this.header = header;
        storageDao = new StorageDaoImpl();
    }

    @Override
    public List<String> makeReport() {
        List<String> report = new ArrayList<>();
        report.add(header);
        for (String fruit : storageDao.getAll().keySet()) {
            report.add(fruit + delimiter + storageDao.get(fruit));
        }
        return report;
    }
}
