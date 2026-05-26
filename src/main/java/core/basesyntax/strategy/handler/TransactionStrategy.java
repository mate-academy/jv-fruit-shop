package core.basesyntax.strategy.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class TransactionStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> strategy;

    public TransactionStrategy(Map<FruitTransaction.Operation, OperationHandler> strategy) {
        this.strategy = strategy;
    }

    public void execute(FruitTransaction transaction, Map<String, Integer> fruits) {
        strategy.get(transaction.getOperation()).execute(transaction, fruits);
    }
}
