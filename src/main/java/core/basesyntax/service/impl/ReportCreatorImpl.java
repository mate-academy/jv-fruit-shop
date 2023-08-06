package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String CSV_SPLITTER = ",";
    private static final String REPORT_HEAD = "fruit" + CSV_SPLITTER + "quantity";

    public String createReport(StorageDao storageDao) {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(REPORT_HEAD)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : storageDao.getEntrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(CSV_SPLITTER)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
