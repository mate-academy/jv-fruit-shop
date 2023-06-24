package core.basesyntax.strategy;

import core.basesyntax.model.TypeOfOperation;
import core.basesyntax.strategy.actions.ActionWithFruits;
import core.basesyntax.strategy.actions.impl.ActionWithFruitsBalance;
import core.basesyntax.strategy.actions.impl.ActionWithFruitsPurchase;
import core.basesyntax.strategy.actions.impl.ActionWithFruitsReturn;
import core.basesyntax.strategy.actions.impl.ActionWithFruitsSupply;
import java.util.HashMap;
import java.util.Map;

public class ActionStrategyImpl implements ActionsStrategy {
    private final Map<TypeOfOperation, ActionWithFruits> actionWithFruitsMap;

    public ActionStrategyImpl() {
        actionWithFruitsMap = new HashMap<>();
        actionWithFruitsMap.put(TypeOfOperation.BALANCE, new ActionWithFruitsBalance());
        actionWithFruitsMap.put(TypeOfOperation.SUPPLY, new ActionWithFruitsSupply());
        actionWithFruitsMap.put(TypeOfOperation.PURCHASE, new ActionWithFruitsPurchase());
        actionWithFruitsMap.put(TypeOfOperation.RETURN, new ActionWithFruitsReturn());
    }

    @Override
    public ActionWithFruits get(TypeOfOperation type) {
        return actionWithFruitsMap.get(type);
    }
}
