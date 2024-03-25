package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

public interface IFruitTransactionDao {
    void add(FruitTransaction fruitStorage);

    FruitTransaction getByIndex(int index);

    int getLength();
}
