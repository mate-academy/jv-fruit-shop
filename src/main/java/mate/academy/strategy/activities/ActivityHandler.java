package mate.academy.strategy.activities;

import mate.academy.model.FruitTransaction;

public interface ActivityHandler {
    void workWithFruits(FruitTransaction transaction);
}
