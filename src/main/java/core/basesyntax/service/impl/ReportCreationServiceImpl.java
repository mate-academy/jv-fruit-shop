package core.basesyntax.service.impl;

import core.basesyntax.db.DatabaseDaoService;
import core.basesyntax.service.ReportCreationService;
import java.util.Map;

public class ReportCreationServiceImpl implements ReportCreationService {
    private static final String CSV_PUNCTUATION_MARK = ",";
    private final DatabaseDaoService databaseDao;
    private final StringBuilder reportStringBuilder;

    public ReportCreationServiceImpl(DatabaseDaoService databaseDao, StringBuilder reportStringBuilder) {
        this.databaseDao = databaseDao;
        this.reportStringBuilder = reportStringBuilder;
    }

    @Override
    public String createReport() {
        Map<String, Integer> data = databaseDao.getAll();
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            reportStringBuilder.append(entry.getKey())
                    .append(CSV_PUNCTUATION_MARK)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportStringBuilder.toString();
    }
}
