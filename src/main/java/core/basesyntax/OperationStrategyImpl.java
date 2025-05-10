package core.basesyntax;

import java.util.Map;

public class OperationStrategyImpl extends OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void execute(ShopStorage storage, FruitTransaction transaction) {
        OperationHandler handler = operationHandlers.get(transaction.getOperation());
        if (handler != null) {
            handler.handle(storage, transaction);
        } else {
            System.out.println("Unknown operation: " + transaction.getOperation());
        }
    }
}
