package dao;

import model.FruitTransaction;

import java.util.List;

public interface TransactionDao {
//    void createTransaction();
//    void deleteTransaction();
//    void updateTransaction();
    void addTransaction(FruitTransaction transaction);

    List<FruitTransaction> getTransaction();





}
