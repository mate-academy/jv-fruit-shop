package core.basesyntax.dao;

import core.basesyntax.model.FruitOperation;
import java.util.List;

public interface FruitOperationDao {
    void add(FruitOperation fruitOperation);

    FruitOperation get(FruitOperation fruitOperation);

    List<FruitOperation> getAll();
}
