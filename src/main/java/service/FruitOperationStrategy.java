package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitOperationStrategy {
    void fillStorage(List<FruitTransaction> fruitTransactions);
}
