package service;

import java.util.List;
import model.FruitTransaction;

public interface ProcessService {
    void process(List<FruitTransaction> fruitTransactionList);
}
