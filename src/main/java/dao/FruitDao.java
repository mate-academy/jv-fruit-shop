package dao;

import java.util.List;

public interface FruitDao {
    void add(String content);

    List<String> get();
}
