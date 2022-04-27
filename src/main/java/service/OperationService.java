package service;

import java.util.List;
import model.FruitTransaction;

public interface OperationService {
    void calculate(List<FruitTransaction> fruitTransactions);
}
