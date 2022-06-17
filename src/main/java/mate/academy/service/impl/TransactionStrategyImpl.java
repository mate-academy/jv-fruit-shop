package mate.academy.service.impl;

import java.util.Map;
import mate.academy.service.TransactionStrategy;
import mate.academy.service.calculation.TransactionCalculation;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<String, TransactionCalculation> transactionCalculationMap;

    public TransactionStrategyImpl(Map<String, TransactionCalculation> calculationMap) {
        this.transactionCalculationMap = calculationMap;
    }

    public TransactionCalculation get(String operation) {
        return transactionCalculationMap.get(operation);
    }
}
