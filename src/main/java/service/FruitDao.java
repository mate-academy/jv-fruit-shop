package service;

import java.util.List;

public interface FruitDao {
    void add(String fruit, Integer count);

    void set(String fruit, Integer count);

    void subtract(String fruit, Integer count);

    List<String[]> getBalance();
}
