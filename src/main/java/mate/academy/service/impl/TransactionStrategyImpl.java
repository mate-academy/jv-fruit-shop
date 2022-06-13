package mate.academy.service.impl;

import mate.academy.model.FruitTransaction;
import mate.academy.service.TransactionStrategy;
import mate.academy.service.calculation.TransactionCalculation;

import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<FruitTransaction.Operation, TransactionCalculation> transactionCalculationMap;

    public TransactionStrategyImpl(Map<FruitTransaction.Operation, TransactionCalculation> transactionCalculationMap) {
        this.transactionCalculationMap = transactionCalculationMap;
    }
    public TransactionCalculation get(FruitTransaction.Operation operation) {
        return transactionCalculationMap.get(operation);
    }
}
