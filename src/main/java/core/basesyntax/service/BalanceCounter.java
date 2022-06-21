package core.basesyntax.service;

import core.basesyntax.fruit.Fruit;
import java.util.List;

public interface BalanceCounter {
    void calculateBalance(List<Fruit> fruitsMoving, ActionStrategy mapStrategy);
}
