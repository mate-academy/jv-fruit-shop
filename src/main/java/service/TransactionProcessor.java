package service;

import java.util.List;
import model.Transaction;
import strategy.OperationStrategy;

public interface TransactionProcessor {

    void createReport(List<Transaction> transactionsList, OperationStrategy operationStrategy);
}
