package mate.academy.strategy.activities;

import mate.academy.model.FruitTransaction;

public interface ActivityHandler {
    void handle(FruitTransaction transaction);
}
