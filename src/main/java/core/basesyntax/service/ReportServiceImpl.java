package core.basesyntax.service;

import core.basesyntax.dao.StoreCsvDao;
import core.basesyntax.entity.FruitTransaction;

import java.util.List;

public class ReportServiceImpl implements ReportService{

    private static final String REPORT_FILE_NAME = "resources\\dailyreport.csv";
    StoreCsvDao storeCsvDao;
    OperationStrategy operationStrategy;

    ReportServiceImpl(StoreCsvDao storeCsvDao, OperationStrategy operationStrategy) {
        this.storeCsvDao = storeCsvDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void generateReport(String toFile) {

        List<FruitTransaction> dailyActivities = storeCsvDao.getAll();

    }
}
