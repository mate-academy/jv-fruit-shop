package service;

import java.util.List;
import models.FruitTransaction;

public interface Processor {
    void process(List<FruitTransaction> fruitTransactionList);
}
