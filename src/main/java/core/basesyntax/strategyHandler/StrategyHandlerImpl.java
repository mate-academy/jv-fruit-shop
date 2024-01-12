package core.basesyntax.strategyHandler;

import core.basesyntax.storage.FruitTransaction;
import core.basesyntax.strategy.*;

import java.util.HashMap;
import java.util.Map;

public class StrategyHandlerImpl implements StrategyHandler{
    public ShopStrategy strategyHandler(FruitTransaction.Operation operation) {
        Map<FruitTransaction.Operation, ShopStrategy> strategyMap = new HashMap<>();
        strategyMap.put(FruitTransaction.Operation.BALANCE, new ShopBalance());
        strategyMap.put(FruitTransaction.Operation.RETURN, new ShopReturn());
        strategyMap.put(FruitTransaction.Operation.SUPPLY, new ShopSupply());
        strategyMap.put(FruitTransaction.Operation.PURCHASE, new ShopPurchase());
        return strategyMap.get(operation);
    }
}
