package service;

import java.util.List;

public interface TransactionCreatorService {
    void creteTransactionsList(List<String> linesFromFile);
    List<TransactionService> getListOfTransactions();
}
