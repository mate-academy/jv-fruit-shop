package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DaoTransactions {
    List<FruitTransaction> getFromTS();

    void addToStorage(FruitTransaction transaction);

    void addToStorage(List<FruitTransaction> transactions);
}
