package service;

import model.FruitTransaction;

public interface FruitTransactionService {
    FruitTransaction createNewTransaction(String type, String fruit, int amount);
}
