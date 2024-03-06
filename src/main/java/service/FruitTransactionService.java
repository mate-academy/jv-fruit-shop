package service;

import model.FruitTransaction;
import model.Operation;
import java.util.List;

public interface FruitTransactionService {
    List<FruitTransaction> processFruitTransaction(List<FruitTransaction> fruitTransactions);
}
