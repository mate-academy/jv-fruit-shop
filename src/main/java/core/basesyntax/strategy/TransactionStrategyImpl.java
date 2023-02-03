package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.transaction.OperationHandler;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> transactionHandlerMap;

    public TransactionStrategyImpl(
            Map<FruitTransaction.Operation, OperationHandler> transactionHandlerMap
    ) {
        this.transactionHandlerMap = transactionHandlerMap;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return transactionHandlerMap.get(operation);
    }
}
