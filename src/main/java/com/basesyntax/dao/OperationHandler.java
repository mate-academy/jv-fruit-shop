package com.basesyntax.dao;

import com.basesyntax.model.Fruit;

public interface OperationHandler {
    Fruit apply(Fruit fruit, int amount);
}
