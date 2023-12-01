package service.impl;

import dao.ReportDao;
import service.ReportGenerator;

import java.util.Map;

public class ReportGenerateImpl implements ReportGenerator {
    private static final String TITLE_REPORT = "fruit,quantity";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String FIELDS_SEPARATOR = ",";
    private ReportDao reportDao;

    public ReportGenerateImpl(ReportDao reportDao) {
        this.reportDao = reportDao;
    }

    @Override
    public String generateReport() {
        Map<String, Integer> report = reportDao.getReport();
        StringBuilder generator = new StringBuilder();

        generator.append(TITLE_REPORT).append(LINE_SEPARATOR);

        report.forEach((key, value) -> generator
                .append(key).append(FIELDS_SEPARATOR).append(value)
                .append(LINE_SEPARATOR));

        return generator.toString();
    }
}
