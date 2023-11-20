package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitTransactionService {
    String processTransactions(List<FruitTransaction> transactions);
}
