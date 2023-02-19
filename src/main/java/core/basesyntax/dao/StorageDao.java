package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface StorageDao {

    boolean containsFruit(Fruit fruit);

    int checkAvailableQuantity(Fruit fruit);

    void add(Fruit fruit, int quantity);

    String generateReport();
}
