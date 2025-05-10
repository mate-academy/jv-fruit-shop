package service;

import java.util.List;
import model.FruitTransaction;

public interface TransactionProcessor {
    void processTransactions(List<FruitTransaction> listFruitTransaction);
}
