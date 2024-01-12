package core.basesyntax.strategyhandler;

import core.basesyntax.storage.FruitTransaction;
import core.basesyntax.strategy.ShopBalance;
import core.basesyntax.strategy.ShopPurchase;
import core.basesyntax.strategy.ShopReturn;
import core.basesyntax.strategy.ShopStrategy;
import core.basesyntax.strategy.ShopSupply;
import java.util.HashMap;
import java.util.Map;

public class StrategyHandlerImpl implements StrategyHandler {
    public ShopStrategy strategyHandler(FruitTransaction.Operation operation) {
        Map<FruitTransaction.Operation, ShopStrategy> strategyMap = new HashMap<>();
        strategyMap.put(FruitTransaction.Operation.BALANCE, new ShopBalance());
        strategyMap.put(FruitTransaction.Operation.RETURN, new ShopReturn());
        strategyMap.put(FruitTransaction.Operation.SUPPLY, new ShopSupply());
        strategyMap.put(FruitTransaction.Operation.PURCHASE, new ShopPurchase());
        return strategyMap.get(operation);
    }
}
