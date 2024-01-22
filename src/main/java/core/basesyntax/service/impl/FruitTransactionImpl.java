package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.List;

public class FruitTransactionImpl implements FruitTransaction {
    private static final String SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private OperationStrategy operationStrategy;

    public FruitTransactionImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public List<String> processBalance() {
        OperationHandler handler = operationStrategy.get(Fruit.Operation.BALANCE);
        if (handler != null) {
            return handler.processOperation();
        } else {
            throw new IllegalArgumentException("Unsupported operation type: BALANCE");
        }
    }

    @Override
    public List<String> processPurchase() {
        OperationHandler handler = operationStrategy.get(Fruit.Operation.PURCHASE);
        if (handler != null) {
            return handler.processOperation();
        } else {
            throw new IllegalArgumentException("Unsupported operation type: BALANCE");
        }
    }

    @Override
    public List<String> processReturn() {
        OperationHandler handler = operationStrategy.get(Fruit.Operation.RETURN);
        if (handler != null) {
            return handler.processOperation();
        } else {
            throw new IllegalArgumentException("Unsupported operation type: BALANCE");
        }
    }

    @Override
    public List<String> processSupply() {
        OperationHandler handler = operationStrategy.get(Fruit.Operation.SUPPLY);
        if (handler != null) {
            return handler.processOperation();
        } else {
            throw new IllegalArgumentException("Unsupported operation type: BALANCE");
        }
    }
}
