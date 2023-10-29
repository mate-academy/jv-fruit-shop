package service;

import java.util.List;
import model.Transaction;

public interface DataParserService {
    List<Transaction> getTransactionsList(List<String> readLines);
}
