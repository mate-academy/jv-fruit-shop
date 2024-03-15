package service;

import java.util.List;
import model.FruitTransaction;

public interface TransactionService {
    void transactionsProcess(List<FruitTransaction> transactions);
}
