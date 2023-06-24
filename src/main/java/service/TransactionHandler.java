package service;

import java.util.List;
import model.FruitTransaction;

public interface TransactionHandler {
    void proccesFruitTransaction(List<FruitTransaction> fruitTransactions);
}
