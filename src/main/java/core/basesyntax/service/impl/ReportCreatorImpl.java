package core.basesyntax.service.impl;

import core.basesyntax.db.Dao;
import core.basesyntax.db.DaoImpl;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

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
        reportBuilder.append(TITLE);
        for (Map.Entry<String, Integer> entry : dao.getAllEntries()) {
            String record = createRecord(entry);
            reportBuilder.append(SEPARATOR).append(record);
        }
        return reportBuilder.toString();
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
