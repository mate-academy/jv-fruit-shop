package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitTransactionService {
    List<FruitTransaction> parseTransactions(List<String> transactions);
}
