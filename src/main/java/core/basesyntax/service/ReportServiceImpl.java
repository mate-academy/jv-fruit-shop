package core.basesyntax.service;

import core.basesyntax.dao.ResourcesDao;
import core.basesyntax.dao.ResourcesDaoImpl;
import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_FIRST_LINE = "fruit,quantity";
    private StorageDao storageDao = new StorageDaoImpl();
    private ResourcesDao resourcesDao = new ResourcesDaoImpl();

    @Override
    public void makeReport(String filePath) {
        List<String> report = storageDao.getProductInfo();
        report.add(0, REPORT_FIRST_LINE);
        resourcesDao.writeToFile(filePath, report);
    }

}
