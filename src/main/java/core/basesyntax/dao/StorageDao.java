package core.basesyntax.dao;

public interface StorageDao {
    void balance(Item item);

    void purchase(Item item);

    void returnItem(Item item);

    void supply(Item item);
}
