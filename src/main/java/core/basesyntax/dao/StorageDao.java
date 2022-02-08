package core.basesyntax.dao;

import core.basesyntax.model.FruitCrate;
import java.util.List;

public interface StorageDao {
    FruitCrate add(FruitCrate fruitCrate);

    FruitCrate update(String fruitName, int quantity);

    FruitCrate get(String fruitName);

    List<FruitCrate> getAll();

    FruitCrate remove(String fruitName);
}
