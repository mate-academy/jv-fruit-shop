package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceFruitAmountCalculateStrategy;
import core.basesyntax.strategy.impl.PurchaseFruitAmountCalculateStrategy;
import core.basesyntax.strategy.impl.ReturnFruitAmountCalculateStrategy;
import core.basesyntax.strategy.impl.SupplyFruitAmountCalculateStrategy;

import java.util.HashMap;
import java.util.Map;

public class OperationStrategyHolder {
    private static Map<FruitTransaction.Operation, FruitAmountCalculateStrategy> map;

    static {
        map = new HashMap<>();
        map.put(FruitTransaction.Operation.BALANCE, new BalanceFruitAmountCalculateStrategy());
        map.put(FruitTransaction.Operation.SUPPLY, new SupplyFruitAmountCalculateStrategy());
        map.put(FruitTransaction.Operation.PURCHASE, new PurchaseFruitAmountCalculateStrategy());
        map.put(FruitTransaction.Operation.RETURN, new ReturnFruitAmountCalculateStrategy());
    }


    public static FruitAmountCalculateStrategy getStrategy(FruitTransaction.Operation operation) {
        return map.get(operation);
    }

}
