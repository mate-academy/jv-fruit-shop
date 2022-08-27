package core.basesyntax.service;

import core.basesyntax.dao.ActivityDaoCsv;
import core.basesyntax.dao.ActivityDaoDb;
import core.basesyntax.dao.ReportDao;
import core.basesyntax.model.Activity;
import core.basesyntax.service.strategy.ReportService;

public class TransactionServiceImpl implements TransactionService {
    private final ActivityDaoCsv activityDaoCsv;
    private final ActivityDaoDb activityDaoDb;
    private final ReportDao reportDao;
    private final ReportService reportService;

    public TransactionServiceImpl(ActivityDaoCsv activityDaoCsv, ActivityDaoDb activityDaoDb,
                                  ReportDao reportDao, ReportService reportService) {
        this.activityDaoCsv = activityDaoCsv;
        this.activityDaoDb = activityDaoDb;
        this.reportDao = reportDao;
        this.reportService = reportService;
    }

    @Override
    public void moveDataFromFileToDb(String fromFile) {
        for (Activity activity : activityDaoCsv.getAll(fromFile)) {
            activityDaoDb.add(activity);
        }
    }

    @Override
    public void createReport(String toFile) {
        reportDao.saveReport(reportService.makeReport(), toFile);
    }
}
