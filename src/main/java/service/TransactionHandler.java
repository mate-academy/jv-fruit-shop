package service;

import java.util.List;
import model.FruitTransaction;

public interface TransactionHandler {
    void parse(List<FruitTransaction> fruitTransactions);
}
