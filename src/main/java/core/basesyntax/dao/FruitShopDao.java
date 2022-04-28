package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitShopDao {
    void save(FruitTransaction fruitTransaction);

    Integer getValue(FruitTransaction fruitTransaction);

    List<FruitTransaction> getAll();
}
