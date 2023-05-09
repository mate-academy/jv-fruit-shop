package core.basesyntax.stretegy;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.stretegy.handlers.OperationBalance;
import core.basesyntax.stretegy.handlers.OperationHandler;
import core.basesyntax.stretegy.handlers.OperationPurchase;
import core.basesyntax.stretegy.handlers.OperationReturn;
import core.basesyntax.stretegy.handlers.OperationSupply;
import java.util.HashMap;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private final Map<FruitTransaction.Operation, OperationHandler> hendlerMap;

    {
        hendlerMap = new HashMap<>();
        hendlerMap.put(FruitTransaction.Operation.BALANCE, new OperationBalance());
        hendlerMap.put(FruitTransaction.Operation.PURCHASE, new OperationPurchase());
        hendlerMap.put(FruitTransaction.Operation.RETURN, new OperationReturn());
        hendlerMap.put(FruitTransaction.Operation.SUPPLY, new OperationSupply());
    }

    public Map<FruitTransaction.Operation, OperationHandler> getHendlerMap() {
        return hendlerMap;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return hendlerMap.get(operation);
    }
}
