package service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface CalculateBalance {
    Map<String, Integer> calculateBalance(List<FruitTransaction> fruitTransactionList);
}
