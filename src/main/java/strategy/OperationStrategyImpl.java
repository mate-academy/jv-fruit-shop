package strategy;

import model.FruitTransaction;

import java.util.List;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    List<String> transactions;
    Map<FruitTransaction.Operation, OperationStrategy> strategyMap;
    private OperationStrategy operationStrategy;

    public OperationStrategyImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public OperationStrategy getOperationStrategy() {
        return operationStrategy;
    }

    public void setOperationStrategy(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void apply(List<String> operation, Map<FruitTransaction.Operation, OperationStrategy> quantity) {
        operationStrategy.apply(transactions, strategyMap);
    }
}
