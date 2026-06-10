package core.basesyntax.service.impl;

import static core.basesyntax.util.CsvUtil.CSV_SEPARATOR;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class CsvReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit" + CSV_SEPARATOR
            + "quantity" + System.lineSeparator();
    private final StorageDao storageDao;

    public CsvReportGeneratorImpl() {
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder(REPORT_HEADER);
        Map<String, Integer> fruitsMap = storageDao.getAll();
        fruitsMap.forEach((key, value) -> report.append(key)
                .append(CSV_SEPARATOR)
                .append(value)
                .append(System.lineSeparator()));

        return report.toString();
    }
}
