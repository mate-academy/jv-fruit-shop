package core.basesyntax;

import core.basesyntax.dao.ActivityDaoCsv;
import core.basesyntax.dao.ActivityDaoCsvImpl;
import core.basesyntax.dao.ActivityDaoDb;
import core.basesyntax.dao.ActivityDaoDbImpl;
import core.basesyntax.dao.ReportDao;
import core.basesyntax.dao.ReportDaoCsvImpl;
import core.basesyntax.service.ActivityStrategyImpl;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.TransactionServiceImpl;
import core.basesyntax.service.maps.ActivityToOperation;
import core.basesyntax.service.strategy.ReportService;
import core.basesyntax.service.strategy.ReportServiceImpl;

public class Main {
    public static void main(String[] args) {
        ActivityDaoCsv activityDaoCsv = new ActivityDaoCsvImpl();
        ActivityDaoDb activityDaoDb = new ActivityDaoDbImpl();
        ReportDao reportDao = new ReportDaoCsvImpl();
        ReportService reportService = new ReportServiceImpl(
                activityDaoDb,
                new ActivityStrategyImpl(ActivityToOperation.getMap()));

        TransactionService transactionService = new TransactionServiceImpl(activityDaoCsv,
                activityDaoDb, reportDao, reportService);
        transactionService.moveDataFromFileToDb("data2508202.csv");
        transactionService.createReport("report.csv");
    }
}
