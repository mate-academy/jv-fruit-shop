package core.basesyntax.service;

import core.basesyntax.dao.ActivityDaoCsv;
import core.basesyntax.dao.ActivityDaoCsvImpl;
import core.basesyntax.dao.ActivityDaoDb;
import core.basesyntax.dao.ActivityDaoDbImpl;
import core.basesyntax.dao.ReportDao;
import core.basesyntax.dao.ReportDaoCsvImpl;
import core.basesyntax.model.Activity;
import core.basesyntax.service.maps.ActivityToOperation;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionServiceImpl implements TransactionService {
    private final ActivityDaoCsv activityDaoCsv;
    private final ActivityDaoDb activityDaoDb;
    private final ReportDao reportDao;
    private final ActivityStrategy activityStrategy;

    public TransactionServiceImpl() {
        activityDaoCsv = new ActivityDaoCsvImpl();
        reportDao = new ReportDaoCsvImpl();
        activityDaoDb = new ActivityDaoDbImpl();
        activityStrategy = new ActivityStrategyImpl(ActivityToOperation.getMap());
    }

    @Override
    public void moveDataFromFileToDb(String fromFile) {
        for (Activity activity : activityDaoCsv.getAll(fromFile)) {
            activityDaoDb.add(activity);
        }
    }

    @Override
    public void createReport(String toFile) {
        Map<String, Integer> dataReport = activityDaoDb.getAll().stream()
                .collect(Collectors.groupingBy(
                        Activity::getFruit,
                        Collectors.summingInt(v ->
                                activityStrategy.get(v.getType()).prepareCount(v.getCount())
                        )
                ));
        reportDao.saveReport(dataReport, toFile);
    }
}
