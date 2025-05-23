package core.basesyntax.dao;

import core.basesyntax.model.FruitOperation;
import java.util.Optional;

public interface FruitOperationDao {
    void add(FruitOperation fruitOperation);

    Optional<FruitOperation> get(String fruit);

    void update(FruitOperation fruitOperation);
}
