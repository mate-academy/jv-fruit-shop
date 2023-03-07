package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitShopDao {

    Map<Fruit, Integer> getRecords();

    void setRecords(Map<Fruit, Integer> dataMap);

    int getDbSize();
}
