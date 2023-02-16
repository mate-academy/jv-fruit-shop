package service;

import java.util.List;
import model.FruitTransaction;

public interface TransactionParser {
    public List<FruitTransaction> parseTransactions(List<String> transactions);
}
