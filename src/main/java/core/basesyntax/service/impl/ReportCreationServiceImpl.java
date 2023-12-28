package core.basesyntax.service.impl;

import core.basesyntax.db.DatabaseDaoService;
import core.basesyntax.db.DatabaseDaoServiceImpl;
import core.basesyntax.service.ReportCreationService;
import java.util.Map;

public class ReportCreationServiceImpl implements ReportCreationService {
    private static final String CSV_PUNCTUATION_MARK = ",";
    private static final String CSV_FIRST_LINE = "product,quantity" + System.lineSeparator();
    private static final DatabaseDaoService databaseDao = new DatabaseDaoServiceImpl();
    private static final StringBuilder reportStringBuilder = new StringBuilder(CSV_FIRST_LINE);

    @Override
    public String createReport() {
        Map<String, Integer> data = databaseDao.getAll();
        for (int position = 0; position < data.keySet().size(); position++) {
            reportStringBuilder.append(data.keySet().toArray()[position])
                    .append(CSV_PUNCTUATION_MARK)
                    .append(data.values().toArray()[position])
                    .append(System.lineSeparator());
        }
        return reportStringBuilder.toString();
    }
}
