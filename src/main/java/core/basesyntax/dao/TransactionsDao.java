package core.basesyntax.dao;

import java.util.Map;

public interface TransactionsDao {
    void add(String fruit, Integer quantity);

    Map<String, Integer> get();
}
