package core.basesyntax.service.impl;

import core.basesyntax.exception.StrategyNotFoundException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StrategyService;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.Map;

public class TransactionStrategyService implements StrategyService {
    private final Map<FruitTransaction.Operation, TransactionStrategy> strategies;

    public TransactionStrategyService(
            Map<FruitTransaction.Operation,
                    TransactionStrategy> strategies
    ) {
        this.strategies = strategies;
    }


    @Override
    public TransactionStrategy getTransactionStrategy(FruitTransaction transaction) {
        if (!strategies.containsKey(transaction.getOperation())) {
            throw new StrategyNotFoundException(String.format(
                    "Operation %s not found",
                    transaction.getOperation().name())
            );
        }
        return strategies.get(transaction.getOperation());
    }
}
