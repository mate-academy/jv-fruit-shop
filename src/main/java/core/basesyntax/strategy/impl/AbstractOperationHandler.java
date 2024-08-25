package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.enums.Operation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.validator.MapValidator;
import java.util.Map;

public abstract class AbstractOperationHandler implements OperationHandler {
    private final Operation targetOperation;
    private final MapValidator mapValidator;

    protected AbstractOperationHandler(Operation targetOperation, MapValidator mapValidator) {
        this.targetOperation = targetOperation;
        this.mapValidator = mapValidator;
    }

    @Override
    public void process(Map<String, Integer> fruitQuantityMap, FruitTransaction transaction) {
        validateTransactionOperation(transaction);
        mapValidator.validateMap(fruitQuantityMap, transaction);
        processTransaction(fruitQuantityMap, transaction);
    }

    protected abstract void processTransaction(Map<String, Integer> fruitQuantityMap,
                                               FruitTransaction transaction);

    private void validateTransactionOperation(FruitTransaction transaction) {
        Operation transactionOperation = transaction.getOperation();
        String exceptionMessage = "Expected to receive transaction with operation = ["
                + targetOperation + "], but found operation = ["
                + transactionOperation + "]";
        if (transactionOperation != targetOperation) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
