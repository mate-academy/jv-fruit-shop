package service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface TransactionService {
    Map<String, Integer> countsFruitsAfterWorkDay(List<FruitTransaction> fruitTransactionList);
}
