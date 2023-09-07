package core.basesyntax.strategy;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface OperationStrategy {
    OperationHandler getOperationHandler(FruitTransaction fruitTransaction,
                                  Map<FruitTransaction.Operation, OperationHandler> handlerMap);
}
