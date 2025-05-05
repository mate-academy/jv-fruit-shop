package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

import java.math.BigDecimal;

public interface OperationHandler {
    void updateNumberOffFruit(String fruit, int amount);
}
