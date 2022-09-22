package core.basesyntax.dao;

public interface StorageDao {
    void update(String fruit,Integer count);

    boolean checkFruit(String fruit);

    void createFruit(String fruit);

    Integer getCountFruit(String fruit);

    String getAllFruitsFromStorage();
}
