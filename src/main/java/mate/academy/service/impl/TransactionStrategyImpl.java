package mate.academy.service.impl;

import java.util.Map;
import mate.academy.model.FruitTransaction;
import mate.academy.service.TransactionStrategy;
import mate.academy.service.calculation.TransactionCalculation;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<FruitTransaction.Operation, TransactionCalculation> transactionCalculationMap;

    public TransactionStrategyImpl(Map<FruitTransaction.Operation,
                                        TransactionCalculation> calculationMap) {
        this.transactionCalculationMap = calculationMap;
    }

    public TransactionCalculation get(FruitTransaction.Operation operation) {
        return transactionCalculationMap.get(operation);

    }
}
