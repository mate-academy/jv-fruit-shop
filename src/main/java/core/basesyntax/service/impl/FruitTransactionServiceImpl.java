package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    @Override
    public void execute(List<FruitTransaction> transactions, 
            Map<Operation, OperationHandler> strategyMap) {
        OperationStrategy operationStrategy = new OperationStrategyImpl(strategyMap);
        
        for (FruitTransaction transaction : transactions) {
            operationStrategy.get(transaction.getOperation()).handle(transaction);
        }
    }
}
