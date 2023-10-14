package core.basesyntax.fruittransact.strategy;

import core.basesyntax.fruittransact.FruitService;
import core.basesyntax.fruittransact.PurchaseService;
import core.basesyntax.fruittransact.RemnantService;
import core.basesyntax.fruittransact.SupplyService;

public class FruitTransactionStrategyImpl implements FruitTransactionStrategy {
    @Override
    public FruitService get(String type) {
        switch (type) {
            case "b":
                return new RemnantService();
            case "p":
                return new PurchaseService();
            case "s":
            case "r":
                return new SupplyService();
            default:
                throw new RuntimeException("No such transaction type: " + type);
        }
    }
}
