package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final Map<String, OperationStrategy> operationStrategies;

    public FruitServiceImpl(Map<String, OperationStrategy> operationStrategies) {
        this.operationStrategies = operationStrategies;
    }

    @Override
    public void processTransaction(FruitTransaction transaction) {
            FruitTransaction.Operation operationType = transaction.getOperation();
            OperationStrategy strategy = operationStrategies.get(operationType.getCode());
            strategy.applyStrategy(transaction);
        }
    }
