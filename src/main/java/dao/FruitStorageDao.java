package dao;

import java.util.Map;
import model.FruitTransaction;

public interface FruitStorageDao {
    void addTransaction(FruitTransaction transaction);

    Map<String, Integer> getData();
}
