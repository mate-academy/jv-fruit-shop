package service.impl;

import model.FruitTransaction;
import service.FruitsAmountStrategy;
import strategy.BalanceHandler;
import strategy.FruitsAmountHandler;
import strategy.PurchaseHandler;
import strategy.ReturnHandler;
import strategy.SupplyHandler;

public class FruitsAmountStrategyImpl implements FruitsAmountStrategy {

    @Override
    public FruitsAmountHandler get(FruitTransaction.Operation operation) {
        switch (operation) {
            case BALANCE:
                return new BalanceHandler();
            case SUPPLY:
                return new SupplyHandler();
            case PURCHASE:
                return new PurchaseHandler();
            case RETURN:
                return new ReturnHandler();
            default:
                throw new RuntimeException("");
        }
    }
}
