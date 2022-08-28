package core.basesyntax.service;

import core.basesyntax.dao.ActivityDaoDb;
import core.basesyntax.model.Activity;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String CSV_SEPARATOR = ",";
    private static final String CSV_HEAD_REPORT = "fruit,quantity";
    private static final String CSV_END_LINE = System.lineSeparator();
    private final ActivityDaoDb activityDaoDb;
    private final ActivityStrategy activityStrategy;

    public ReportServiceImpl(ActivityDaoDb activityDaoDb, ActivityStrategy activityStrategy) {
        this.activityDaoDb = activityDaoDb;
        this.activityStrategy = activityStrategy;
    }

    @Override
    public String makeReport() {
        return CSV_HEAD_REPORT + CSV_END_LINE
            + activityDaoDb.getAll().stream()
                    .collect(Collectors.groupingBy(
                            Activity::getFruit,
                            Collectors.summingInt(v ->
                                    activityStrategy.get(v.getType()).prepareCount(v.getCount())
                            )
                    ))
                    .entrySet().stream()
                    .map(e -> e.getKey() + CSV_SEPARATOR + e.getValue())
                    .collect(Collectors.joining(CSV_END_LINE));
    }
}
