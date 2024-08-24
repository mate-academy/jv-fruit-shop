package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.enums.Operation;
import core.basesyntax.strategy.OperationHandler;

import java.util.Map;

public abstract class AbstractOperationHandler implements OperationHandler {
    private final Operation targetOperation;

    protected AbstractOperationHandler(Operation targetOperation) {
        this.targetOperation = targetOperation;
    }

    @Override
    public void process(Map<String, Integer> fruitQuantityMap, FruitTransaction transaction) {
       validateTransactionOperation(transaction);
       processTransaction(fruitQuantityMap, transaction);
    }

    protected abstract void processTransaction(Map<String, Integer> fruitQuantityMap,
                                               FruitTransaction transaction);
    void validateTransactionOperation(FruitTransaction transaction) {
        Operation transactionOperation = transaction.getOperation();
        String exceptionMessage = "Expected to receive transaction with operation = ["
                + targetOperation + "], but found operation = ["
                + transactionOperation + "]";
        if (transactionOperation != targetOperation) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
