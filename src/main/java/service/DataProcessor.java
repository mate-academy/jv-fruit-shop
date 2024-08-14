package service;

import java.util.List;
import model.FruitTransaction;

public interface DataProcessor {
    void process(List<FruitTransaction> fruitTransactions);
}
