package core.basesyntax.dao;

import core.basesyntax.model.FruitCrate;
import java.util.List;

public interface StorageDao {
    FruitCrate update(FruitCrate fruitCrate);

    FruitCrate get(String fruitName);

    List<FruitCrate> getAll();

    FruitCrate remove(String fruitName);
}
