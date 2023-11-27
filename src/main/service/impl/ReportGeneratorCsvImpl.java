package main.service.impl;

import main.dao.ReportDao;
import main.service.ReportGenerator;

import java.util.Map;

public class ReportGeneratorCsvImpl implements ReportGenerator {
    private final String TITLE_ROW = "fruit,quantity";
    private final String LINE_SEPARATOR = System.lineSeparator();
    private final String FIELD_SEPARATOR = ",";
    private ReportDao reportDao;

    public ReportGeneratorCsvImpl(ReportDao reportDao) {
        this.reportDao = reportDao;
    }

    @Override
    public String create() {
        Map<String, Integer> reportData = reportDao.get();
        StringBuilder builder = new StringBuilder();

        builder
            .append(TITLE_ROW)
            .append(LINE_SEPARATOR);

        reportData.forEach((key, value) -> builder
            .append(key)
            .append(FIELD_SEPARATOR)
            .append(value)
            .append(LINE_SEPARATOR));

        return builder.toString();
    }
}
