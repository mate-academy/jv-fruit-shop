package dao;

import model.FruitTransaction;

import java.util.List;

public interface StorageDao {
    void addTransaction(FruitTransaction transaction);
    List<FruitTransaction> getAllTransaction();
    void clearDataBase();
}
