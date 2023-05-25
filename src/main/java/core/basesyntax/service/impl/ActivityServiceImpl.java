package core.basesyntax.service.impl;

import core.basesyntax.enumeration.Operation;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ActivityService;
import core.basesyntax.strategy.FruitHandler;
import core.basesyntax.strategy.impl.BalanceFruitHandlerImpl;
import core.basesyntax.strategy.impl.PurchaseFruitHandlerImpl;
import core.basesyntax.strategy.impl.ReturnFruitHandlerImpl;
import core.basesyntax.strategy.impl.SupplyFruitHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityServiceImpl implements ActivityService {
    private final Map<Operation, FruitHandler> fruitStrategyMap = new HashMap<>() {{
            put(Operation.BALANCE, new BalanceFruitHandlerImpl());
            put(Operation.SUPPLY, new SupplyFruitHandlerImpl());
            put(Operation.PURCHASE, new PurchaseFruitHandlerImpl());
            put(Operation.RETURN, new ReturnFruitHandlerImpl());
            }};

    @Override
    public void getAllActivitiesInTheShop(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            FruitHandler fruitHandler = fruitStrategyMap.get(transaction.getOperation());
            if (fruitHandler != null) {
                fruitHandler.getActivity(transaction);
            }
        }
    }
}
