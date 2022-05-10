package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class ActivitiesStrategyImpl implements ActivitiesStrategy {
    private Map<FruitTransaction.Operation, ActivitiesHandler> activitiesHandlerMap;

    public ActivitiesStrategyImpl() {
        activitiesHandlerMap = new HashMap<>();
    }

    public ActivitiesHandler get(FruitTransaction.Operation operation) {
        switch (operation) {
            case RETURN:
                return new ActivitiesHandlerReturn();
            case BALANCE:
                return new ActivitiesHandlerBalance();
            case PURCHASE:
                return new ActivitiesHandlerPurchase();
            case SUPPLY:
                return new ActivitiesHandlerSupply();
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
