package service;

import java.util.List;
import models.FruitTransaction;

public interface FruitService {
    void process(List<FruitTransaction> fruitTransactionList);
}
