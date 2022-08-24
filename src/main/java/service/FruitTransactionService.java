package service;

import model.FruitTransaction;

public interface FruitTransactionService {
    FruitTransaction createFruitTransaction(String type, String fruit, int quantity);
    FruitTransaction createFruitTransaction(String stringFromFile);
    void doTransaction(FruitTransaction transaction);
}
