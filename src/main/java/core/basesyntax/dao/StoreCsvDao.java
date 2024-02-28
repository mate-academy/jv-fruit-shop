package core.basesyntax.dao;

import core.basesyntax.entity.Fruit;
import core.basesyntax.entity.FruitTransaction;

import java.util.List;

public interface StoreCsvDao {
    void add(Fruit fruit, int quantity);
    List<FruitTransaction> get(Fruit fruit, int quantity);

    List<FruitTransaction> getAll();
    void update(Fruit fruit, int quantity);
    void delete(Fruit fruit, int quantity);
}
