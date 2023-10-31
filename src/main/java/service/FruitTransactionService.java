package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitTransactionService {
    void processFruitTransactions(List<FruitTransaction> fruitTransactions);
}
