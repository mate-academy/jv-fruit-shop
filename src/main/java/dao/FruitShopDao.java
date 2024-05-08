package dao;

import java.util.List;
import model.FruitTransaction;

public interface FruitShopDao {
    List<FruitTransaction> get(String fruit);

    List<FruitTransaction> getAll();

    void add(FruitTransaction newTransaction);
}
