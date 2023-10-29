package core.basesyntax.service.calculator;

import core.basesyntax.service.operation.FruitOperation;

public interface OperationCalculator {
    void handle(FruitOperation fruitTransaction);
}
