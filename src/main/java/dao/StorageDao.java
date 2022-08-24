package dao;

import java.util.List;
import model.FruitTransaction;

public interface StorageDao {
    void addTransaction(FruitTransaction transaction);

    List<FruitTransaction> getAllTransaction();

    void clearDataBase();
}
