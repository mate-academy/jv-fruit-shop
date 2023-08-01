package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operators.Operator;

public interface OperatorStrategy {
    Operator operatorHandler(FruitTransaction.Operation operator);
}
