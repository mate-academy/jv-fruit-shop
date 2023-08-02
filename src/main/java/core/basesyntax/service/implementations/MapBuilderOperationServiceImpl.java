package core.basesyntax.service.implementations;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.MapBuilderOperationService;
import core.basesyntax.strategy.handler.BalanceDataHandler;
import core.basesyntax.strategy.handler.DataHandler;
import core.basesyntax.strategy.handler.PurchaseDataHandler;
import core.basesyntax.strategy.handler.ReturnDataHandler;
import core.basesyntax.strategy.handler.SupplyDataHandler;
import java.util.HashMap;
import java.util.Map;

public class MapBuilderOperationServiceImpl implements MapBuilderOperationService {
    private final Map<FruitTransaction.Operation, DataHandler> enumHandlerMap =
            new HashMap<>();

    @Override
    public Map<FruitTransaction.Operation, DataHandler> initializeMap() {
        DataHandler balance = new BalanceDataHandler();
        DataHandler supply = new SupplyDataHandler();
        DataHandler purchase = new PurchaseDataHandler();
        DataHandler returns = new ReturnDataHandler();
        enumHandlerMap.put(FruitTransaction.Operation.BALANCE, balance);
        enumHandlerMap.put(FruitTransaction.Operation.RETURN, returns);
        enumHandlerMap.put(FruitTransaction.Operation.PURCHASE, purchase);
        enumHandlerMap.put(FruitTransaction.Operation.SUPPLY, supply);
        return enumHandlerMap;
    }
}
