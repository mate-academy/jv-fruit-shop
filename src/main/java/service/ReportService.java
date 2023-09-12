package service;

import database.Storage;
import java.util.List;

public interface ReportService {
    void createReport(List<TransactionService> transactionServiceList, Storage storage);
}
