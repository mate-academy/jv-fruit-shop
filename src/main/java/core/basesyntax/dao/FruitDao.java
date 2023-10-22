package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FruitDao {
    void putTransaction(FruitTransaction transaction);

    List<FruitTransaction> getTransactions(final Fruit fruit);

    Set<Map.Entry<Fruit, List<FruitTransaction>>> getTransactions();

    void saveBalance(Map<Fruit, Integer> balance);

    Map<Fruit, Integer> getBalance();

    void clear();
}
