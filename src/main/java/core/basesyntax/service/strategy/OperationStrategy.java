package core.basesyntax.service.strategy;

import core.basesyntax.service.calculator.OperationCalculator;
import core.basesyntax.service.operation.FruitOperation;

public interface OperationStrategy {

    OperationCalculator getOperationType(FruitOperation fruitTransaction);
}
