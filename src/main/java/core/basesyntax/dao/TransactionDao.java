package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionDao {
    void add(FruitTransaction transaction);

    List<FruitTransaction> get(String fileName);
}
