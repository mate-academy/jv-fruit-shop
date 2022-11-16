package core.basesyntax.strategy;

import core.basesyntax.service.FruitTransaction;

public interface IFruitStrategy {
    FruitTransaction chooseOperation(String operation, String fruit, Integer quantity);
}
