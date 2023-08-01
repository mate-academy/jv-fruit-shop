package dao;

import java.util.Map;

public interface DbDao {
    Map<String, Integer> getData();

    void updateData(Map<String, Integer> data);
}
