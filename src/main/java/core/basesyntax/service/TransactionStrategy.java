package core.basesyntax.service;

import core.basesyntax.FruitTransaction;

public class TransactionStrategy {
    public OperationHandler getShopService(FruitTransaction fruit) {
        switch (fruit.getOperation()) {
            case BALANCE -> {
                return new BalanceService();
            }
            case SUPPLY -> {
                return new SupplyService();
            }
            case RETURN -> {
                return new ReturnService();
            }
            case PURCHASE -> {
                return new PurchaseService();
            }
            default -> throw new RuntimeException("Unknown operation");
        }
    }
}
