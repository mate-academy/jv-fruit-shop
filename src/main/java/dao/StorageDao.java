package dao;

import java.util.List;

public interface StorageDao {
    int get(String fruit);

    List<String> getAll();

    void add(String fruit, int value);

    void update(String fruit, int value);

    boolean hasFruit(String fruit);
}
