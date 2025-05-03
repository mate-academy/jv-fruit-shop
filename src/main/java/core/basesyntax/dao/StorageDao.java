package core.basesyntax.dao;

public interface StorageDao {

    void add(String fruit, Integer amount);

    int get(String fruit);
}
