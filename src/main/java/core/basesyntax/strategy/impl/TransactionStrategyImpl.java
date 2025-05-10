package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionHandler;
import core.basesyntax.strategy.TransactionStrategy;

public class TransactionStrategyImpl implements TransactionStrategy {
    @Override
    public TransactionHandler getHandler(FruitTransaction transaction) {
        String operation = transaction.getOperation();
        return switch (operation) {
            case "p" -> new TransactionHandlerPurchaseImpl();
            case "r" -> new TransactionHandlerReturnImpl();
            case "s" -> new TransactionHandlerSupplyImpl();
            case "b" -> new TransactionHandlerImpl();
            default -> new TransactionHandlerImpl();
        };
    }
}
