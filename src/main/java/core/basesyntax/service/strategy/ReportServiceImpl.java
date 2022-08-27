package core.basesyntax.service.strategy;

import core.basesyntax.dao.ActivityDaoDb;
import core.basesyntax.model.Activity;
import core.basesyntax.service.ActivityStrategy;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private final ActivityDaoDb activityDaoDb;
    private final ActivityStrategy activityStrategy;

    public ReportServiceImpl(ActivityDaoDb activityDaoDb, ActivityStrategy activityStrategy) {
        this.activityDaoDb = activityDaoDb;
        this.activityStrategy = activityStrategy;
    }

    @Override
    public Map<String, Integer> makeReport() {
        return activityDaoDb.getAll().stream()
                .collect(Collectors.groupingBy(
                        Activity::getFruit,
                        Collectors.summingInt(v ->
                                activityStrategy.get(v.getType()).prepareCount(v.getCount())
                        )
                ));
    }
}
