package core.basesyntax.dao;

import core.basesyntax.model.Fruits;
import java.util.Optional;

public interface FruitsDao {
    void add(Fruits fruit);

    Optional<Fruits> getFruitsIfPresent(String fruitName);
}
