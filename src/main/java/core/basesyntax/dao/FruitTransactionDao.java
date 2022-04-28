package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionDao {
    void add(FruitTransaction fruitTransaction);

    FruitTransaction get(String fruit);

    void update(FruitTransaction fruitTransaction);

    List<FruitTransaction> getAll();
}
