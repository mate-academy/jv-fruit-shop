package service;

import java.util.List;
import model.FruitTransaction;

public interface CalculationService {
    void calculate(List<FruitTransaction> fruitTransactionList);
}
