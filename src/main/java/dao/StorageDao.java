package dao;

public interface StorageDao {

    void add(String fruit, Integer amount);

    Integer getAmount(String fruit);

    void update(String fruit, Integer amount);
}
