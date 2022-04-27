package service;

import model.FruitTransaction;
import java.util.List;

public interface OperationService {
    void calculate(List<FruitTransaction> fruitTransactions);
}
