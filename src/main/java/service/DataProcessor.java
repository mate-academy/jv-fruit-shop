package service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface DataProcessor {
    Map<String, Integer> process(List<FruitTransaction> fruitTransactions);
}
