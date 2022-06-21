package Strategy.Impl;

import Strategy.TransactionStrategy;
import model.FruitTransaction;

import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private Map<String, FruitTransaction.Operation> operationMap;

    public TransactionStrategyImpl(Map<String, FruitTransaction.Operation> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public FruitTransaction.Operation get(String data) {
        return operationMap.get(data);
    }
}
