package dao;

import java.util.List;

public interface FruitStorageDao {
    int getNumer(String fruit);

    List<String> getAll();

    void save(String fruit, int number);

    void update(String fruit, int number);

    boolean hasInDb(String fruit);
}
