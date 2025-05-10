package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.factory.StrategyFactory;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class TransactionServiceImpl implements TransactionService {
    private final Map<String, BigDecimal> inventory;

    public TransactionServiceImpl(Map<String, BigDecimal> inventory) {
        this.inventory = inventory;
    }

    @Override
    public boolean processTransactions(List<FruitTransaction> transactions) {
        try {
            for (FruitTransaction transaction : transactions) {
                OperationStrategy strategy = StrategyFactory
                        .getStrategy(transaction.getOperation());
                if (strategy == null) {
                    throw new IllegalStateException("No strategy found for operation: "
                            + transaction.getOperation());
                }
                strategy.apply(inventory, transaction);
            }
            return true;
        } catch (Exception e) {
            throw new IllegalStateException("Error processing transactions: " + e);
        }
    }
}
