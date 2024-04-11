package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface StorageDao {
    void add(FruitTransaction fruitTransaction);

    FruitTransaction get(String fruitName);

    List<FruitTransaction> getAll();
}
