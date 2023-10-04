package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private final String caption;
    private final String separator;
    private final StorageDao storageDao;

    public ReportServiceImpl(String caption, String separator) {
        this.caption = caption;
        this.separator = separator;
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public List<String> generateReport() {
        List<String> report = new ArrayList<>();
        report.add(caption);
        for (String fruit :storageDao.getAllFruits().keySet()) {
            report.add(fruit + separator + storageDao.getFruitQuantity(fruit));
        }
        return report;
    }
}
