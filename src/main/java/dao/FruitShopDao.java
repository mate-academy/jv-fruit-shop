package dao;

import java.util.List;
import model.FruitTransaction;

public interface FruitShopDao {
    void save(FruitTransaction fruitTransaction);

    Integer getValue(FruitTransaction fruitTransaction);

    List<FruitTransaction> getAll();
}
