package service;

import java.util.List;
import model.FruitTransaction;

public interface CalculateBalance {
    void calculateBalance(List<FruitTransaction> fruitTransactionList);
}
