package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

import java.util.List;
import java.util.Map;

public interface FruitShopDao {
    void add(String fruit, Integer value);
    Map<String, Integer> get();
}
