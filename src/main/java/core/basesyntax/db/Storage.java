package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;

import java.util.Map;

public interface Storage {
    void add(String fruit, Integer quantity) ;

    Integer getQuantityByFruit(String fruit);

    Map<String, Integer> getAll();
}
