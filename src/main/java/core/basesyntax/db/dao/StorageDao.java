package core.basesyntax.db.dao;

import core.basesyntax.model.Item;

public interface StorageDao {
    void balance(Item item);

    void purchase(Item item);

    void returnItem(Item item);

    void supply(Item item);
}
