package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;

import java.util.Map;

public interface OperationStrategy {

    OperationHandler get(FruitTransaction.Operation operation);
}
