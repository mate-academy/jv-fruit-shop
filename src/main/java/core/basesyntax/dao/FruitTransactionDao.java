package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionDao {
    void add(FruitTransaction fruitTransaction);

    FruitTransaction get(int index);

    List<FruitTransaction> getAll();

}
