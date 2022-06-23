package service.impl;

import db.Dao;
import db.DaoImpl;
import java.util.Map;
import service.ReportCreator;

public class ReportCreatorImpl implements ReportCreator {
    private static final String SEPARATOR = System.lineSeparator();
    private static final String TITLE = "fruit,quantity";

    @Override
    public String create() {
        Dao dao = new DaoImpl();
        if (dao.isStorageEmpty()) {
            return "";
        }
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(TITLE).append(SEPARATOR);
        for (Map.Entry<String, Integer> entry : dao.getAllEntries()) {
            String record = createRecord(entry);
            reportBuilder.append(record).append(SEPARATOR);
        }
        return reportBuilder.toString().trim();
    }

    private String createRecord(Map.Entry<String, Integer> entry) {
        StringBuilder builder = new StringBuilder();
        String record = builder
                .append(entry.getKey())
                .append(",")
                .append(entry.getValue())
                .toString();
        return record;
    }
}
