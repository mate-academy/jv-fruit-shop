package core.basesyntax.strategy;

import core.basesyntax.operation.OperationHandler;
import core.basesyntax.storage.Storage;
import core.basesyntax.transactions.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public void process(FruitTransaction transaction, Storage storage) {
        FruitTransaction.Operation operation = transaction.getOperation();
        OperationHandler handler = handlers.get(operation);
        handler.operate(transaction, storage);
    }
}
