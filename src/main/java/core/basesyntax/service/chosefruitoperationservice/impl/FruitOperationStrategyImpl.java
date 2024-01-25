package core.basesyntax.service.chosefruitoperationservice.impl;

import core.basesyntax.service.chosefruitoperationservice.FruitOperationHandler;
import core.basesyntax.service.chosefruitoperationservice.FruitOperationStrategy;

public class FruitOperationStrategyImpl implements FruitOperationStrategy {
    @Override
    public FruitOperationHandler getOperation(String code) {
        return switch (code) {
            case "b" -> new BalanceFruitHandlerImpl();
            case "p" -> new PurchaseFruitHandlerImpl();
            case "s" -> new SupplyFruitHandlerImpl();
            case "r" -> new ReturnFruitHandlerImpl();
            default -> throw new RuntimeException("You input not correct code");
        };
    }
}
