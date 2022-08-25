package core.basesyntax.storage;

import core.basesyntax.model.Fruit;

import java.util.Map;

public interface Dao {
    Map<Fruit, Integer> getBalance();
    int getAmount(Fruit fruit);
    void updateBalance(Fruit fruit, int amount);
}
