package core.basesyntax.dao;

import core.basesyntax.model.FruitCrate;
import java.util.List;

public interface StorageDao {
    void add(FruitCrate fruitCrate);

    FruitCrate get(String fruitName);

    List<FruitCrate> getAll();
}
