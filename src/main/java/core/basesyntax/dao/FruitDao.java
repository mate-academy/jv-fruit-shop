package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface FruitDao {
    int getFruitAmount (FruitTransaction fruitTransaction);
    void add (FruitTransaction fruitTransaction);
    void changeAmount (FruitTransaction fruitTransaction, int newAmount);
}
