package dao;

import model.FruitTransaction;

public interface TransactionsDao {

    void processTransaction(FruitTransaction transaction);
    void addTransactionInfo(FruitTransaction transaction);

    FruitTransaction getTransaction(String fruitName);
}
