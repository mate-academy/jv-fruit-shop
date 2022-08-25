package core.basesyntax.service;

import core.basesyntax.dao.ActivityDao;
import core.basesyntax.dao.ActivityDaoCsvImpl;
import core.basesyntax.dao.ReportDao;
import core.basesyntax.dao.ReportDaoCsvImpl;
import core.basesyntax.model.Activity;
import core.basesyntax.model.TypeActivity;
import core.basesyntax.service.strategy.ActivityStrategy;
import core.basesyntax.service.strategy.data.ActivityToOperation;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionService {
    private static final Map<TypeActivity, ActivityStrategy> ACTIVITIES_TO_OPERATION
            = ActivityToOperation.getMap();
    private final ActivityDao activityDao;
    private final ReportDao reportDao;

    public TransactionService() {
        activityDao = new ActivityDaoCsvImpl();
        reportDao = new ReportDaoCsvImpl();
    }

    public void createReport(String fileName) {
        Map<String, Integer> dataReport = activityDao.getAll(fileName).stream()
                .collect(Collectors.groupingBy(
                        Activity::getFruit,
                        Collectors.summingInt(v ->
                            ACTIVITIES_TO_OPERATION
                                    .get(v.getType())
                                    .prepareCount(v.getCount())
                        )
                ));
        reportDao.saveReport(dataReport);
    }
}
