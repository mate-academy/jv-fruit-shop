package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public interface TransactionDao {
    void addTransaction(FruitTransaction transaction);

    void addFruit(Fruit fruit);

    Fruit getFruit(String fruitType);
}
