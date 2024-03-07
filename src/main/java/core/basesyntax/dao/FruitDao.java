package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitDao {
    void add(FruitTransaction fruitTransaction);

    FruitTransaction get(String fruit);

    void remove(FruitTransaction fruitTransaction);

    List<FruitTransaction> getAll();
}
