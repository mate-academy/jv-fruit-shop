package core.basesyntax.dao;

import core.basesyntax.model.FruitCrate;
import java.util.List;

public interface StorageDao {
    void update(FruitCrate fruitCrate);

    FruitCrate get(String fruitName);

    List<FruitCrate> getAll();
}
