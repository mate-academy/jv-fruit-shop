package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface FruitDao {
    void add(FruitTransaction fruit);
    List<FruitTransaction> getAll();
}
