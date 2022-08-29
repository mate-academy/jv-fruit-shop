package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ActivityDaoDb {
    void add(FruitTransaction fruitTransaction);

    List<FruitTransaction> getAll();
}
