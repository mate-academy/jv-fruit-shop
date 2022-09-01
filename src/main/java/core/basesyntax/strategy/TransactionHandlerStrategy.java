package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class TransactionHandlerStrategy {
    private final Map<FruitTransaction.Operation, TransactionHandler> handlersMap;

    public TransactionHandlerStrategy(Map handlersMap) {
        this.handlersMap = handlersMap;
    }

    public TransactionHandler get(FruitTransaction.Operation operation) {
        return handlersMap.get(operation);
    }
}
