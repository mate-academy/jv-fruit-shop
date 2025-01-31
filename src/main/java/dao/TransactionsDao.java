package dao;

import model.FruitTransaction;

import java.util.List;

public interface TransactionsDao {

    void processTransaction(FruitTransaction transaction);

    void updateTransactionInfo(FruitTransaction transaction);

    List<FruitTransaction> getAll();

    FruitTransaction getTransactionByName(String fruitName);

    FruitTransaction findOrCreateFruit(FruitTransaction transaction);
}
