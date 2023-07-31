package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

public interface FruitTranzactionDao {
    void add(FruitTransaction fruitTransaction);

    FruitTransaction get(int index);

    int getSizeStorage();
}
