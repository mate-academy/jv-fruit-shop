package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.AddToBalanceStrategy;
import core.basesyntax.strategy.FruitShopTransaction;
import core.basesyntax.strategy.PurchaseStrategy;

import java.util.Map;

public class FruitShopTransactionImpl implements FruitShopTransaction {
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";
    private final AddToBalanceStrategy addToBalanceStrategy;
    private final PurchaseStrategy purchaseStrategy;

    public FruitShopTransactionImpl() {
        addToBalanceStrategy = new AddToBalanceStrategyImpl();
        purchaseStrategy = new PurchaseStrategyImpl();
    }

    @Override
    public void fruitTransaction(Map<String, Integer> dataForReport,
                                 String activityType, String fruit, int quantity) {
        switch (activityType) {
            case BALANCE:
            case SUPPLY:
            case RETURN: addToBalanceStrategy.action(dataForReport, fruit, quantity);
                break;
            case PURCHASE: purchaseStrategy.action(dataForReport, fruit, quantity);
                break;
            default: throw new RuntimeException("Invalid data!");
        }
    }
}
