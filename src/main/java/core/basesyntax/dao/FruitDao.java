package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

import java.util.List;

public interface FruitDao {
    void add(Fruit fruit);

    void changeBalanceForFruit(String name, long quantity);

    long getBalance(String name);

    List<Fruit> getFullStorage();
}
