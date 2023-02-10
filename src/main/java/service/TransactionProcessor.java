package service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface TransactionProcessor {
    Map<String, Integer> process(List<FruitTransaction> fruitTransactions);
}
