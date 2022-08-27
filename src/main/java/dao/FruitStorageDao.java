package dao;

import model.FruitTransaction;

import java.util.Map;

public interface FruitStorageDao {
    void addTransaction(FruitTransaction transaction);
    Map<String, Integer> getData();
}
