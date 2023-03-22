package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface TransactionDao {
    void add(Fruit fruit, Integer quantity);

    Integer get(String fruit);

    void addAll(List<FruitTransaction> fruitTransactions);
}
