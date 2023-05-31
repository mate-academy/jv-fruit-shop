package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationsToMapService;
import core.basesyntax.strategy.TypeStrategy;
import core.basesyntax.strategy.impl.BalanceTypeStrategy;
import core.basesyntax.strategy.impl.PurchaseStrategyImpl;
import core.basesyntax.strategy.impl.ReturnTypeStrategyImpl;
import core.basesyntax.strategy.impl.SupplyTypeStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class OperationsToMapServiceImpl implements OperationsToMapService {

    @Override
    public Map<FruitTransaction.Operation, TypeStrategy> operationsToMap() {
        Map<FruitTransaction.Operation, TypeStrategy> actionsMap = new HashMap<>();
        actionsMap.put(FruitTransaction.Operation.BALANCE, new BalanceTypeStrategy());
        actionsMap.put(FruitTransaction.Operation.SUPPLY, new SupplyTypeStrategyImpl());
        actionsMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseStrategyImpl());
        actionsMap.put(FruitTransaction.Operation.RETURN, new ReturnTypeStrategyImpl());
        return actionsMap;
    }
}
