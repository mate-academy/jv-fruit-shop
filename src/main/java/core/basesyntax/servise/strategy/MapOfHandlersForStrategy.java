package core.basesyntax.servise.strategy;

import core.basesyntax.servise.FruitTransaction;
import java.util.Map;

public interface MapOfHandlersForStrategy {
    Map<FruitTransaction.Operation, OperationService> getMap();
}
