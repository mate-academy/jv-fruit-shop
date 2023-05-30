package service;

import java.util.List;
import model.FruitTransaction;

public interface TransactionService {
    List<FruitTransaction> parseTransactions(List<String> transactions);
}
