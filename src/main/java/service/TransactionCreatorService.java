package service;

import java.util.List;
import model.Transaction;

public interface TransactionCreatorService {
    List<Transaction> creteTransactionsList(List<String> linesFromFile);
}
