package core.basesyntax.dao;

import java.util.Map;

public interface StoreDao {
    void addFruits(String nameOfGood, Integer amount);

    Map<String, Integer> get();
}
