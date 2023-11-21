package service;

import java.util.List;
import model.FruitTransaction;

public interface ParseFruitTransactionService {
    void parseFruitTransactions(List<FruitTransaction> fruitTransactions);
}
