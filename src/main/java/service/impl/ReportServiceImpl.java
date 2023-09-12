package service.impl;

import database.Storage;
import java.util.List;
import service.ReportService;
import service.TransactionService;

public class ReportServiceImpl implements ReportService {

    @Override
    public void createReport(List<TransactionService> transactionServiceList, Storage storage) {
        for (TransactionService transactionService : transactionServiceList) {
            String fruit = transactionService.getFruitName();
            int value = transactionService.getFruitValue();
            transactionService.getFruitOperationType()
                    .doTransaction(storage.getReportList(), fruit, value);
        }
    }
}
