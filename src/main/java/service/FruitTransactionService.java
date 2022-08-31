package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitTransactionService {
    List<FruitTransaction> parseFruitTransactions(List<String> inputData);
}
