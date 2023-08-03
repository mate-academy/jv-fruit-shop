package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operators.OperationHandler;
import core.basesyntax.service.OperatorStrategy;
import java.util.Map;

public class OperatorStrategyImpl implements OperatorStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> transactionOperator;

    public OperatorStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> transactionOperator) {
        this.transactionOperator = transactionOperator;
    }

    @Override
    public OperationHandler getOperatorHandler(FruitTransaction.Operation operator) {
        return transactionOperator.get(operator);
    }
}
