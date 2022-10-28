package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.BalanceStrategy;
import core.basesyntax.strategy.FruitShopTransaction;
import core.basesyntax.strategy.PurchaseStrategy;
import core.basesyntax.strategy.ReturnStrategy;
import core.basesyntax.strategy.SupplyStrategy;
import java.util.Map;

public class FruitShopTransactionImpl implements FruitShopTransaction {
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";
    private final BalanceStrategy balanceStrategy;
    private final SupplyStrategy supplyStrategy;
    private final ReturnStrategy returnStrategy;
    private final PurchaseStrategy purchaseStrategy;

    public FruitShopTransactionImpl() {
        balanceStrategy = new BalanceStrategyImpl();
        supplyStrategy = new SupplyStrategyImpl();
        returnStrategy = new ReturnStrategyImpl();
        purchaseStrategy = new PurchaseStrategyImpl();
    }

    @Override
    public void fruitTransaction(Map<String, Integer> dataForReport,
                                 String activityType, String fruit, int quantity) {
        switch (activityType) {
            case BALANCE: balanceStrategy.action(dataForReport, fruit, quantity);
                break;
            case SUPPLY: supplyStrategy.action(dataForReport, fruit, quantity);
                break;
            case RETURN:returnStrategy.action(dataForReport, fruit, quantity);
                break;
            case PURCHASE: purchaseStrategy.action(dataForReport, fruit, quantity);
                break;
            default: throw new RuntimeException("Invalid data!");
        }
    }
}
