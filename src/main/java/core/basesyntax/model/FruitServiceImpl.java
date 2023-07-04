package core.basesyntax.model;

import core.basesyntax.service.strategy.OperationStrategy;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private Map<String, OperationStrategy> operationStrategies;

    public FruitServiceImpl(Map<String, OperationStrategy> operationStrategies) {
        this.operationStrategies = operationStrategies;
    }

    @Override
    public void processFruitTransactions(FruitTransaction[] transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationStrategy strategy = operationStrategies.get(transaction.getOperation()
                    .getCode());
            if (strategy != null) {
                strategy.process(transaction);
            }
        }
    }

}
