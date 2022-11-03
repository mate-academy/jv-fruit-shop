package core.basesyntax.utils;

import core.basesyntax.dao.StorageDao;
import java.util.ArrayList;
import java.util.List;

public class ReportUtil {
    private static final String CSV_OUTPUT_HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    public List<String> generateReport(StorageDao storageDao) {
        List<String> reportList = new ArrayList<>();
        reportList.add(CSV_OUTPUT_HEADER);
        storageDao.getAll().forEach((key, value) -> reportList.add(key + SEPARATOR + value));
        return reportList;
    }
}
