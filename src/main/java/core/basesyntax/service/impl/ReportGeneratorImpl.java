package core.basesyntax.service.impl;

import core.basesyntax.dao.ReportDao;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String TITLE_REPORT = "fruit,quantity";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String FIELD_SEPARATOR = ",";
    private final ReportDao reportDao;

    public ReportGeneratorImpl(ReportDao reportDao) {
        this.reportDao = reportDao;
    }

    @Override
    public String generate() {
        Map<String, Integer> reportFromDao = reportDao.getReport();
        StringBuilder finalReport = new StringBuilder(TITLE_REPORT).append(LINE_SEPARATOR);
        reportFromDao.forEach((key, val) -> finalReport
                .append(key).append(FIELD_SEPARATOR).append(val)
                .append(LINE_SEPARATOR));
        return finalReport.toString();
    }
}
