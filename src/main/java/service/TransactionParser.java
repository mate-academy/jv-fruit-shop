package service;

import java.util.List;
import model.FruitTransaction;

public interface TransactionParser {
    List<FruitTransaction> parseTransactions(List<String> fileInfo);
}
