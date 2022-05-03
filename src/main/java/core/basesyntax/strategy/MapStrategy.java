package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.operation.Operation;
import core.basesyntax.service.activity.BalanceHandler;
import core.basesyntax.service.activity.OperationHandler;
import core.basesyntax.service.activity.PurchaseHandler;
import core.basesyntax.service.activity.ReturnHandler;
import core.basesyntax.service.activity.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class MapStrategy {
    private final Map<Operation, OperationHandler> map = new HashMap<>();

    public Map<Operation, OperationHandler> mapStrategy(FruitDao fruitDao) {
        map.put(Operation.SUPPLY, new SupplyHandler(fruitDao));
        map.put(Operation.PURCHASE, new PurchaseHandler(fruitDao));
        map.put(Operation.RETURN, new ReturnHandler(fruitDao));
        map.put(Operation.BALANCE, new BalanceHandler(fruitDao));
        return map;
    }
}
