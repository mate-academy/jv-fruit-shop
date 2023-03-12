package fruitshop.dao;

import fruitshop.model.FruitTransaction;
import java.util.List;

public interface FruitShopStorageDao {
    void add(FruitTransaction transaction);

    List<FruitTransaction> getAll();
}
