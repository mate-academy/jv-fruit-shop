package service;

import java.util.List;
import model.Transaction;

public interface ReportService {
    void createReport(List<Transaction> transactionServiceList);
}
