package core.basesyntax.strategy.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

import java.util.Map;

public class TransactionHandler {
    private Map<FruitTransaction.Operation, OperationHandler> strategy;

    public TransactionHandler(Map<FruitTransaction.Operation, OperationHandler> strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Map<FruitTransaction.Operation, OperationHandler> strategy) {
        this.strategy = strategy;
    }

    public void init(FruitTransaction transaction) {
        strategy.get(transaction.getOperation()).execute(transaction);
    }
}
