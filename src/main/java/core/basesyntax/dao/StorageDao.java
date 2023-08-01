package core.basesyntax.dao;

public interface StorageDao {
    void add(String fruit, Integer quantity);

    void take(String fruit, Integer quantity);
    //Fruit get (Fruit fruit);
}
