package core.basesyntax.service.impl;

import core.basesyntax.dao.ActivityDaoDb;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String CSV_SEPARATOR = ",";
    private static final String CSV_HEAD_REPORT = "fruit,quantity";
    private static final String CSV_END_LINE = System.lineSeparator();
    private final ActivityDaoDb activityDaoDb;

    public ReportServiceImpl(ActivityDaoDb activityDaoDb) {
        this.activityDaoDb = activityDaoDb;
    }

    @Override
    public String makeReport() {
        return CSV_HEAD_REPORT + CSV_END_LINE
            + activityDaoDb.getAll().stream()
                    .map(e -> e.getKey().getName() + CSV_SEPARATOR + e.getValue())
                    .collect(Collectors.joining(CSV_END_LINE));
    }
}
