package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface FruitService {
    void createNewFruitEntity(FruitTransaction.Operation operation, String fruit, int quantity);
}
