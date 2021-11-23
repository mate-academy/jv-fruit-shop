package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public interface FruitStorageDao {

    void update(Fruit fruit, int quantity);

    int getQuantity(Fruit fruit);
}
