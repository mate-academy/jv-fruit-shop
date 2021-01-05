package core.dao;

public interface FruitsDao {
    void add(String fruit, int amount);

    int get(String fruit);
}
