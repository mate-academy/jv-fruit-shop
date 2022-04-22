package core.basesyntax.service.report;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport(Map<String, Integer> map) {
        StringBuilder builder = new StringBuilder("fruit,quantity\n");
        StorageDao storageDao = new StorageDaoImpl();
        storageDao.getDataBase().forEach((key, value) -> builder
                .append(key)
                .append(",")
                .append(value)
                .append(System.lineSeparator()));
        return builder.toString();
    }
}
