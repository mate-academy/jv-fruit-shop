package core.basesyntax.service.report;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_HEADER = "fruit,quantity\n";

    @Override
    public String createReport(Map<String, Integer> map) {
        StringBuilder builder = new StringBuilder(REPORT_HEADER);
        StorageDao storageDao = new StorageDaoImpl();
        storageDao.getAll().forEach((key, value) -> builder
                .append(key)
                .append(",")
                .append(value)
                .append(System.lineSeparator()));
        return builder.toString();
    }
}
