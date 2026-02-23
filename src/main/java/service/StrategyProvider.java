package service;

import java.util.HashMap;
import java.util.Map;
import model.Type;

public class StrategyProvider {
    private final Map<Type, ActivityStrategy> strategies = new HashMap<>();

    public StrategyProvider() {
        strategies.put(Type.PURCHASE, new PurchaseStrategy());
        strategies.put(Type.SUPPLY, new SupplyStrategy());
        strategies.put(Type.RETURN, new ReturnStrategy());
        strategies.put(Type.BALANCE, new BalanceStrategy());
    }

    public ActivityStrategy getStrategy(Type operation) {
        return strategies.get(operation);
    }
}
