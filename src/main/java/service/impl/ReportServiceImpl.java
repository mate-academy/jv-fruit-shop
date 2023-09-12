package service.impl;

import database.Storage;
import service.ReportService;
import service.TransactionService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private final Map<String, Integer> reportList;

    public ReportServiceImpl() {
        this.reportList = new HashMap<>();
    }

    @Override
    public void createReport(List<TransactionService> transactionServiceList) {
        for (TransactionService transactionService : transactionServiceList) {
            String fruit = transactionService.getFruitName();
            int value = transactionService.getFruitValue();
            transactionService.getFruitOperationType()
                    .doTransaction(Storage.REPORT_LIST, fruit, value);
        }
    }
}
