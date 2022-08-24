package dao;

import model.FruitTransaction;

import java.util.List;

public interface StorageDao {
    void putTransfer(FruitTransaction transaction);
    List<FruitTransaction> getAllTransaction();
    void clearDataBase();
}
