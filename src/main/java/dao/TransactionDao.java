package dao;

import model.FruitTransaction;

public interface TransactionDao {
//    void createTransaction();
//    void deleteTransaction();
//    void updateTransaction();
    void addTransaction(FruitTransaction transaction);


    void getTransaction(FruitTransaction transaction);

}
