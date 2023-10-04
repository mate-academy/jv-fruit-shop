package service;

import java.util.List;
import model.FruitTransaction;

public interface TransactionHandlerService {
    void handleTransactions(List<FruitTransaction> transactions);
}
