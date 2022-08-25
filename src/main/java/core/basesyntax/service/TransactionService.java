package core.basesyntax.service;

import core.basesyntax.dao.ActivityDao;
import core.basesyntax.dao.ActivityDaoCsvImpl;
import core.basesyntax.dao.ReportDao;
import core.basesyntax.dao.ReportDaoCsvImpl;
import core.basesyntax.model.Activity;
import core.basesyntax.service.maps.ActivityToOperation;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionService {
    private final ActivityDao activityDao;
    private final ReportDao reportDao;
    private final ActivityStrategy activityStrategy;

    public TransactionService() {
        activityDao = new ActivityDaoCsvImpl();
        reportDao = new ReportDaoCsvImpl();
        activityStrategy = new ActivityStrategyImpl(ActivityToOperation.getMap());
    }

    public void createReport(String fileName) {
        Map<String, Integer> dataReport = activityDao.getAll(fileName).stream()
                .collect(Collectors.groupingBy(
                        Activity::getFruit,
                        Collectors.summingInt(v ->
                                activityStrategy.get(v.getType()).prepareCount(v.getCount())
                        )
                ));
        reportDao.saveReport(dataReport);
    }
}
