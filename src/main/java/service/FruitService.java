package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitService {
    void process(List<FruitTransaction> fruitTransactions);
}

