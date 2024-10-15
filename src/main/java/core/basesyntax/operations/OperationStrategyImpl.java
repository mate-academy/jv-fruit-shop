package core.basesyntax.operations;

import core.basesyntax.FruitTransaction;
import core.basesyntax.FruitTransaction.Operation;
import core.basesyntax.Storage;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private final Map<Operation, OperationHandler> operationHandler;

    public OperationStrategyImpl(
            Map<Operation, OperationHandler> operationHandler) {
        this.operationHandler = operationHandler;
    }

    @Override
    public void execute(Storage storage, FruitTransaction transaction) {
        OperationHandler handler = operationHandler.get(transaction.getOperation());
        handler.handle(storage, transaction);
    }
}
