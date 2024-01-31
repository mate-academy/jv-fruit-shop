package core.basesyntax.service.activitieswithfruitservice.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activitieswithfruitservice.TransactionHandler;
import core.basesyntax.service.activitieswithfruitservice.TransactionStrategy;
import java.util.HashMap;
import java.util.Map;

public class TransactionStrategyImpl implements TransactionStrategy {
    private final Map<String, TransactionHandler> transactionHandlers;

    public TransactionStrategyImpl() {
        transactionHandlers = new HashMap<>();
        transactionHandlers.put("b", new BalanceFruitActivitiesServiceImpl());
        transactionHandlers.put("p", new PurchaseFruitActivitiesServiceImpl());
        transactionHandlers.put("r", new ReturnFruitActivitiesServiceImpl());
        transactionHandlers.put("s", new SupplyFruitActivitiesServiceImpl());
    }

    @Override
    public TransactionHandler getTransactionHandler(FruitTransaction fruitTransaction) {
        TransactionHandler handler = transactionHandlers.get(fruitTransaction);
        if (handler != null) {
            return handler;
        } else {
            throw new RuntimeException("Input code is not correct");
        }
    }
}
