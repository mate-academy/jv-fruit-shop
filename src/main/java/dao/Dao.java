package dao;

import java.util.Map;

public interface Dao {
    Map<String, Integer> getStock();

    void updateStock(Map<String, Integer> data);
}
