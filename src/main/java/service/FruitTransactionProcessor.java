package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitTransactionProcessor {
    void process(List<FruitTransaction> fruitTransactions);

}
