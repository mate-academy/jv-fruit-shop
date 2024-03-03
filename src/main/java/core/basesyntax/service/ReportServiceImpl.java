package core.basesyntax.service;

import core.basesyntax.dao.StoreCsvDao;
import core.basesyntax.entity.FruitTransaction;
import core.basesyntax.service.quantity.handlers.OperationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService{

    private static final String REPORT_FILE_NAME = "resources\\finalreport.csv";
    private StoreCsvDao storeCsvDao;
    private OperationStrategy operationStrategy;



    public ReportServiceImpl(StoreCsvDao storeCsvDao, OperationStrategy operationStrategy) {
        this.storeCsvDao = storeCsvDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void generateReport() {
        Map<String,Integer> report = prepareDataForReport();
            storeCsvDao.saveReportToFile(report);
    }

    private Map<String,Integer> prepareDataForReport() {
        Map<String,Integer> fruitMap= new HashMap<>();
        List<FruitTransaction> dailyActivities = storeCsvDao.getAll();
        for (FruitTransaction fruitTransaction : dailyActivities) {
            OperationHandler operationHandler = operationStrategy.operate(fruitTransaction.getOperation());
            operationHandler.handleTransaction(fruitTransaction,fruitMap);
        }
        return fruitMap;
    }
}
