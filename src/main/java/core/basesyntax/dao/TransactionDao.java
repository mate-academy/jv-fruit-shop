package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionDao {

    void add(FruitTransaction translation);

    void delete(FruitTransaction transaction);

    List<FruitTransaction> getAll();
}
