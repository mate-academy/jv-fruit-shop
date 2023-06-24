package dao;

public interface FruitsDao {
    void add(String fruit, Integer quantity);

    int get(String fruit);
}
