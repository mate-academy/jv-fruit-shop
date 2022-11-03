package service;

import java.util.List;
import models.FruitTransaction;

public interface TransactionService {
    void executeOperation(List<FruitTransaction> fruitTransactions);
}
