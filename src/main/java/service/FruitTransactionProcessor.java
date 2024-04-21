package service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface FruitTransactionProcessor {
    Map<String, Integer> process(List<FruitTransaction> fruitTransactions);

}
