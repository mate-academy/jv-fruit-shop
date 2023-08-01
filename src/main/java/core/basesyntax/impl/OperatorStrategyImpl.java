package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operators.Operator;
import core.basesyntax.service.OperatorStrategy;
import java.util.Map;

public class OperatorStrategyImpl implements OperatorStrategy {
    private Map<FruitTransaction.Operation, Operator> transactionOperator;

    public OperatorStrategyImpl(Map<FruitTransaction.Operation, Operator> transactionOperator) {
        this.transactionOperator = transactionOperator;
    }

    @Override
    public Operator operatorHandler(FruitTransaction.Operation operator) {
        return transactionOperator.get(operator);
    }
}
