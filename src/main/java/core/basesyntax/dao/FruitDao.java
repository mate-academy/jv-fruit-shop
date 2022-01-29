package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitDao {
    void addAll(List<FruitTransaction> fruitTransactionList);

    List<FruitTransaction> getAll();
}
