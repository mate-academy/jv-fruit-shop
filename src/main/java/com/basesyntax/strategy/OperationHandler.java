package com.basesyntax.strategy;

import com.basesyntax.model.Fruit;

public interface OperationHandler {
    void apply(Fruit fruit, int amount);
}
