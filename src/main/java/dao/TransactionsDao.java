package dao;

import java.util.Map;

public interface TransactionsDao {
    void add(Map<String, Integer> inputMap);

    Map<String, Integer> get();
}
